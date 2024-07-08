package com.zerobase.consumer.service;

import com.zerobase.consumer.dto.ReviewResponseDto;
import com.zerobase.domain.LoanReview;
import com.zerobase.kafka.dto.LoanRequestDto;
import com.zerobase.repository.LoanReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanRequestService {

    private final LoanReviewRepository loanReviewRepository;

    private final String CSS_URL = "http://localhost:8081/css/api/v1/request";

    public void loanRequest(LoanRequestDto loanRequestDto) {

        saveLoanReviewData(loanRequestToCb(loanRequestDto).toLoanReviewEntity());
    }

    private ReviewResponseDto loanRequestToCb(LoanRequestDto loanRequestDto) {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(1000))
                .setReadTimeout(Duration.ofSeconds(1000))
                .build();

        return restTemplate.postForEntity(CSS_URL, loanRequestDto, ReviewResponseDto.class).getBody();
    }

    private void saveLoanReviewData(LoanReview loanReview) {
        loanReviewRepository.save(loanReview);
    }

}
