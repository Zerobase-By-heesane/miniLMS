package com.zerobase.test;

import com.zerobase.domain.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class TestDto {
    String userKey;
    String userRegistrationNumber;
    String userName;
    Long userIncomeAmount;

    public static TestDto toDto(UserInfo userInfo){
        return TestDto.builder()
                .userKey(userInfo.getUserKey())
                .userRegistrationNumber(userInfo.getUserRegistrationNumber())
                .userName(userInfo.getUserName())
                .userIncomeAmount(userInfo.getUserIncomeAmount())
                .build();
    }
}
