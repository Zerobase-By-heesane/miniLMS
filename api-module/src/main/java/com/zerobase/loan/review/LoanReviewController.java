package com.zerobase.loan.review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "LoanReview", description = "대출 심사 결과 조회 API")
public class LoanReviewController {

    private final LoanReviewService loanReviewService;

    @Operation(summary = "대출 심사 결과 조회 API", description = "대출 심사 결과를 조회하는 API")
    @GetMapping(value = "/review/{userKey}")
    public LoanReviewDto.LoanReviewResponseDto getReviewData(
            @PathVariable
            @Parameter(description = "사용자 식별키")
            String userKey
    ) {
        return loanReviewService.loanReviewMain(userKey);

    }
}
