package com.zerobase.loan.review;

import com.zerobase.domain.LoanReview;
import com.zerobase.exception.CustomErrorCode;
import com.zerobase.exception.CustomException;
import com.zerobase.repository.LoanReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanReviewServiceImpl implements LoanReviewService {

    private final LoanReviewRepository loanReviewRepository;

    @Override
    public LoanReviewDto.LoanReviewResponseDto loanReviewMain(String userKey) {

        return LoanReviewDto.LoanReviewResponseDto.builder()
                .userKey(userKey)
                .loanResult(toResponseDto(getLoanResult(userKey)))
                 .build();
    }

    @Override
    public LoanReviewDto.LoanReview getLoanResult(String userKey) {
        LoanReview loanReview = loanReviewRepository.findByUserKey(userKey)
                .orElseThrow(() -> new CustomException(CustomErrorCode.RESULT_NOT_FOUND));

        return LoanReviewDto.LoanReview.builder()
                .userKey(loanReview.getUserKey())
                .userLimitAmount(loanReview.getLoanLimitedAmount())
                .userLoanInterest(loanReview.getLoanInterest())
                .build();
    }

    private LoanReviewDto.LoanResult toResponseDto(LoanReviewDto.LoanReview loanReview) {
        return LoanReviewDto.LoanResult.builder()
                .userLimitAmount(loanReview.getUserLimitAmount())
                .userLoanInterest(loanReview.getUserLoanInterest())
                .build();
    }
}
