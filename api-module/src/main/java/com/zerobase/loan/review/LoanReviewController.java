package com.zerobase.loan.review;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fintech/api/v1")
@RequiredArgsConstructor
public class LoanReviewController {

    private final LoanReviewService loanReviewService;

    @GetMapping("/review/{userKey}")
    public ResponseEntity<LoanReviewDto.LoanReviewResponseDto> getReviewData(
            @PathVariable String userKey
    ) {
        return ResponseEntity.ok(loanReviewService.loanReviewMain(userKey));

    }
}
