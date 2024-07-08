package com.zerobase.user.service;

import com.zerobase.common.type.ResponseContent;
import com.zerobase.domain.UserInfo;
import com.zerobase.loan.GenerateKey;
import com.zerobase.loan.encrypt.EncryptComponent;
import com.zerobase.loan.request.UserInfoDto;
import com.zerobase.repository.UserInfoRepository;
import com.zerobase.user.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final GenerateKey generateKey;
    private final UserInfoRepository userInfoRepository;
    private final EncryptComponent encryptComponent;

    @Override
    public UserResponse getUserInfo(String userKey) throws Exception {

        UserInfo userInfo = userInfoRepository.findByUserKey(userKey)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저 정보가 없습니다."));

        String userRegistrationNumber = encryptComponent.decryptString(userInfo.getUserRegistrationNumber());

        UserData userData = new UserData(userInfo.getUserKey(), userRegistrationNumber);

        return new UserResponse(userData, ResponseContent.SUCCESS);
    }

    @Override
    public UserInformationDto createUser(UserInputDto userInputDto) throws Exception {
        String userKey = generateKey.generateKey();
        userInputDto.userRegistrationNumber = encryptComponent.encryptString(userInputDto.userRegistrationNumber);

        UserInfoDto userInfoDto = UserInfoDto.builder()
                .userKey(userKey)
                .userIncomeAmount(userInputDto.getUserIncomeAmount())
                .userName(userInputDto.getUserName())
                .userRegistrationNumber(userInputDto.getUserRegistrationNumber())
                .build();

        userInfoRepository.save(userInfoDto.toEntity());

        UserKeyDto userKeyDto = new UserKeyDto(userKey);

        return new UserInformationDto(userKeyDto, ResponseContent.SUCCESS);
    }
}
