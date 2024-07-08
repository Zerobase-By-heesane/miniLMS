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
        log.info("LoanRequestDto: {}", loanRequestDto.toString());
        ReviewResponseDto reviewResponseDto = loanRequestToCb(loanRequestDto);
        log.info("ReviewResponseDto: {}", reviewResponseDto);
        LoanReview loanReviewEntity = reviewResponseDto.toLoanReviewEntity();
        log.info("LoanReviewEntity: {}", loanReviewEntity.toString());
        saveLoanReviewData(loanReviewEntity);
    }

    private ReviewResponseDto loanRequestToCb(LoanRequestDto loanRequestDto) {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofDays(1000))
                .setReadTimeout(Duration.ofDays(1000))
                .build();
        log.info("LoanRequestDto: {}", loanRequestDto.toString());
        ResponseEntity<ReviewResponseDto> reviewResponseDtoResponseEntity = restTemplate.postForEntity(CSS_URL, loanRequestDto, ReviewResponseDto.class);
        log.info("ResponseEntity: {}", reviewResponseDtoResponseEntity.toString());
        ReviewResponseDto body = reviewResponseDtoResponseEntity.getBody();
        log.info("ReviewResponseDto: {}", body.toString());
        return body;
    }

    private void saveLoanReviewData(LoanReview loanReview) {
        loanReviewRepository.save(loanReview);
    }

}
