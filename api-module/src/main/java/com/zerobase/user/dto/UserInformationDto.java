package com.zerobase.user.dto;

import com.zerobase.common.type.ResponseContent;
import lombok.Getter;

@Getter
public class UserInformationDto {
    private final UserKeyDto data;
    private final String responseCode;
    private final String responseMessage;

    public UserInformationDto(UserKeyDto data, ResponseContent responseContent) {
        this.data = data;
        this.responseCode = responseContent.getResponseCode();
        this.responseMessage = responseContent.getResponseMessage();
    }
}
