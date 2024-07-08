package com.zerobase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.zerobase.domain","com.zerobase.repository"})
@SpringBootApplication
public class ApiController {
    public static void main(String[] args) {
        SpringApplication.run(ApiController.class, args);
    }
}
