package com.zerobase.loan.request;

import com.zerobase.domain.UserInfo;
import com.zerobase.loan.GenerateKey;
import com.zerobase.loan.encrypt.EncryptComponent;
import com.zerobase.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoanRequestServiceImpl implements LoanRequestService{

    private final GenerateKey generateKey;
    private final UserInfoRepository userInfoRepository;
    private final EncryptComponent encryptComponent;
//    private final Loan



    @Override
    public LoanRequestResponseDto loanRequestsMain(LoanRequestInputDto loanRequestInputDto) {

        String userKey = generateKey.generateKey();

        saveUserInfo(loanRequestInputDto.toUserInfoDto(userKey));

        loanRequestReview("");

        return null;
    }

    @Override
    public UserInfo saveUserInfo(UserInfoDto userInfoDto) {

        userInfoRepository.save(userInfoDto.toEntity());

        return null;
    }

    @Override
    public void loanRequestReview(String userKey) {

    }
}
