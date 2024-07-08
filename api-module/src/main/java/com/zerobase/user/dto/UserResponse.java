package com.zerobase.user.dto;

import com.zerobase.common.type.ResponseContent;
import com.zerobase.loan.request.UserInfoDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserResponse {
    private UserData data;
    private String code;
    private String responseMessage;

    public UserResponse(UserData data, ResponseContent responseContent) {
        this.data = data;
        this.code = responseContent.getResponseCode();
        this.responseMessage = responseContent.getResponseMessage();
    }
}
