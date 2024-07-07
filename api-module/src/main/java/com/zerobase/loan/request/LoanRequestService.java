package com.zerobase.loan.request;

import com.zerobase.domain.UserInfo;

public interface LoanRequestService {
    LoanRequestResponseDto loanRequestsMain(LoanRequestInputDto loanRequestInputDto);

    UserInfo saveUserInfo(UserInfo userInfo);

    void loanRequestReview(UserInfoDto userInfoDto);
}
