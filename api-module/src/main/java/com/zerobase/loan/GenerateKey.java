package com.zerobase.loan;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateKey {
    public String generateKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
