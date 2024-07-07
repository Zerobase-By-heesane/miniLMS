package com.zerobase.loan.request;

import com.zerobase.domain.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoDto {
    String userKey;
    String userName;
    String userRegistrationNumber;
    String userIncomeAmount;

    public UserInfo toEntity(){
        return UserInfo.builder()
                .userKey(userKey)
                .userName(userName)
                .userRegistrationNumber(userRegistrationNumber)
                .userIncomeAmount(Long.parseLong(userIncomeAmount))
                .build();
    }
}
