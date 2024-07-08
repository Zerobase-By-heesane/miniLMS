package com.zerobase.aop;

import com.zerobase.loan.encrypt.EncryptComponent;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.lang.reflect.Field;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Aspect
@Component
@RequiredArgsConstructor
public class EncryptionAspect {

    private final EncryptComponent encryptComponent;

    @Before("execution(* com.zerobase.*.*.*.save(..))")
    public void encryptBeforeSave(JoinPoint jp) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IllegalAccessException {
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            if (arg instanceof String) {
                encryptFields((arg));

            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.zerobase.*.*.find*(..))", returning = "result")
    public void decryptAfterFind(JoinPoint joinPoint, Object result) throws IllegalAccessException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        if (result instanceof Iterable) {
            for (Object entity : (Iterable<?>) result) {
                decryptFields(entity);
            }
        } else {
            decryptFields(result);
        }
    }

    private void encryptFields(Object obj) throws IllegalAccessException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Encrypt.class)) {
                field.setAccessible(true);
                String plainText = (String) field.get(obj);
                String encryptedText = encryptComponent.encryptString(plainText);
                field.set(obj, encryptedText);
            }
        }
    }

    private void decryptFields(Object obj) throws IllegalAccessException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Encrypt.class)) {
                field.setAccessible(true);
                String encryptedText = (String) field.get(obj);
                String plainText = encryptComponent.decryptString(encryptedText);
                field.set(obj, plainText);
            }
        }
    }
}
