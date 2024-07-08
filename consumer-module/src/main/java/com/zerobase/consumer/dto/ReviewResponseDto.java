package com.zerobase.consumer.dto;

import com.zerobase.domain.LoanReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReviewResponseDto {
    String userKey;
    Long limitAmount;
    Double interest;

    public LoanReview toLoanReviewEntity(){
        return LoanReview.builder()
                .userKey(userKey)
                .loanLimitedAmount(limitAmount)
                .loanInterest(interest)
                .build();
    }
}
