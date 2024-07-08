package com.zerobase.loan.review;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Getter
public class LoanReviewDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class LoanReviewResponseDto{

        @JsonProperty("userKey")
        String userKey;
        @JsonProperty("loanResult")
        LoanResult loanResult;

    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
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
