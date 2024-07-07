package com.zerobase.loan.review;

import org.springframework.stereotype.Service;

@Service
public interface LoanReviewService {

    LoanReviewDto.LoanReviewResponseDto loanReviewMain(String userKey);

    LoanReviewDto.LoanReview getLoanResult(String userKey);
}
