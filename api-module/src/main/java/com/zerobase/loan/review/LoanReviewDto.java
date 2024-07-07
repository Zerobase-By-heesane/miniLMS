package com.zerobase.loan.review;


import lombok.*;

public class LoanReviewDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LoanReviewResponseDto{
        String userKey;
        LoanResult loanResult;

    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LoanResult{
        Long userLimitAmount;
        Double userLoanInterest;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class LoanReview{
        String userKey;
        Long userLimitAmount;
        Double userLoanInterest;
    }

}
