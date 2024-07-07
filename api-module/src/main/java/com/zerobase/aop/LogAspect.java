package com.zerobase.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(Slf4j.class);

    @Pointcut("within(com.zerobase..*)")
    public void inApiModule() {
    }

    @Around("inApiModule()")
    public Object logAround(ProceedingJoinPoint pjp) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = null;
        try {
            result =pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        stopWatch.stop();

        logger.info("Execution time of " + pjp.getSignature().getName() + " :: " + stopWatch.getLastTaskTimeMillis() + " ms. And Args :: " + Arrays.toString(pjp.getArgs()));

        return result;
    }
}
