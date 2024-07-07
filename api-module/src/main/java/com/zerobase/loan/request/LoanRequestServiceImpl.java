package com.zerobase.loan.request;

import com.zerobase.domain.UserInfo;
import com.zerobase.loan.GenerateKey;
import com.zerobase.loan.encrypt.EncryptComponent;
import com.zerobase.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@Service
public class LoanRequestServiceImpl implements LoanRequestService{

    private final GenerateKey generateKey;
    private final UserInfoRepository userInfoRepository;
    private final EncryptComponent encryptComponent;
//    private final Loan



    @Override
    public LoanRequestResponseDto loanRequestsMain(LoanRequestInputDto loanRequestInputDto) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        String userKey = generateKey.generateKey();

        loanRequestInputDto.userRegistrationNumber = encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber);

        saveUserInfo(loanRequestInputDto.toUserInfoDto(userKey));

        loanRequestReview(userKey);

        return new LoanRequestResponseDto(userKey);
    }

    @Override
    public UserInfo saveUserInfo(UserInfoDto userInfoDto) {
        return userInfoRepository.save(userInfoDto.toEntity());
    }

    @Override
    public void loanRequestReview(String userKey) {

    }
}
