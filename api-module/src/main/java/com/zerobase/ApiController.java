package com.zerobase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@EntityScan(basePackages = {"com.zerobase.domain", "com.zerobase.repository"})
@SpringBootApplication
@EnableCaching
public class ApiController {
    public static void main(String[] args) {
        SpringApplication.run(ApiController.class, args);
    }
}
