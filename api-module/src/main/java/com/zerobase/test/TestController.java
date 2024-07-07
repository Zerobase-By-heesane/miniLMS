package com.zerobase.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fintech/api/v1")
public class TestController {

    private final TestService testService;

    @GetMapping("/test/get/{userKey}")
    public TestDto test(@PathVariable String userKey) {
        return testService.testGetService(userKey);
    }

}
