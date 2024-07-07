package com.zerobase.loan.request;

import com.zerobase.domain.UserInfo;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface LoanRequestService {
    LoanRequestResponseDto loanRequestsMain(LoanRequestInputDto loanRequestInputDto) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException;

    UserInfo saveUserInfo(UserInfoDto userInfo);

    void loanRequestReview(String userKey);
}
