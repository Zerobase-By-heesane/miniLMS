package com.zerobase.loan.review;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/fintech/api/v1")
@RequiredArgsConstructor
public class LoanReviewController {

    private final LoanReviewService loanReviewService;

    @GetMapping(value = "/review/{userKey}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoanReviewDto.LoanReviewResponseDto getReviewData(
            @PathVariable String userKey
    ) {
        LoanReviewDto.LoanReviewResponseDto loanReviewResponseDto = loanReviewService.loanReviewMain(userKey);
        log.info("loanReviewResponseDto : {}", loanReviewResponseDto);
        return loanReviewResponseDto;

    }
}
