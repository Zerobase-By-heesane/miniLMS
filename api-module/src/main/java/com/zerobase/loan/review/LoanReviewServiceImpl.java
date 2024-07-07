package com.zerobase.loan.review;

import com.zerobase.domain.LoanReview;
import com.zerobase.repository.LoanReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanReviewServiceImpl implements LoanReviewService {

    private final LoanReviewRepository loanReviewRepository;

    @Override
    public LoanReviewDto.LoanReviewResponseDto loanReviewMain(String userKey) {

        LoanReviewDto.LoanReview loanResult = getLoanResult(userKey);

        return LoanReviewDto.LoanReviewResponseDto.builder()
                .userKey(userKey)
                .loanResult(new LoanReviewDto.LoanResult(
                        loanResult.userLimitAmount,
                        loanResult.userLoanInterest

                ))
                .build();
    }

    @Override
    public LoanReviewDto.LoanReview getLoanResult(String userKey) {
        LoanReview loanReview = loanReviewRepository.findByUserKey(userKey)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저의 대출 심사 결과가 없습니다."));

        return LoanReviewDto.LoanReview.builder()
                .userKey(loanReview.getUserKey())
                .userLimitAmount(loanReview.getLoanLimitedAmount())
                .userLoanInterest(loanReview.getLoanInterest())
                .build();
    }
}
