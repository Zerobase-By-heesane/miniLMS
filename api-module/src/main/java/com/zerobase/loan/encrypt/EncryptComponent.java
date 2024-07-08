package com.zerobase.loan.encrypt;

import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class EncryptComponent {
    private final String SECRETARY = "12345678901234567890123456789012";

    private final Base64.Encoder encoder = Base64.getEncoder();
    private final Base64.Decoder decoder = Base64.getDecoder();

    public String encryptString(String encryptString) throws InvalidAlgorithmParameterException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] bytes = cipherPkcs5(Cipher.ENCRYPT_MODE, SECRETARY).doFinal(encryptString.getBytes(StandardCharsets.UTF_8));
        return encoder.encodeToString(bytes);
    }

    public String decryptString(String decryptString) throws InvalidAlgorithmParameterException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] bytes = decoder.decode(decryptString);
        return new String(cipherPkcs5(Cipher.DECRYPT_MODE, SECRETARY).doFinal(bytes), StandardCharsets.UTF_8);
    }

    public Cipher cipherPkcs5(int opMode, String secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec sk = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec iv = new IvParameterSpec(secretKey.substring(0, 16).getBytes(StandardCharsets.UTF_8));
        instance.init(opMode, sk, iv);
        return instance;
    }
}
