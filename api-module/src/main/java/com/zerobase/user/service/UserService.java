package com.zerobase.user.service;

import com.zerobase.user.dto.UserInformationDto;
import com.zerobase.user.dto.UserInputDto;
import com.zerobase.user.dto.UserResponse;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface UserService {
    UserResponse getUserInfo(String userKey) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, Exception;

    UserInformationDto createUser(UserInputDto userInputDto) throws Exception;
}
