package com.zerobase.loan.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanRequestInputDto {
    String userName;
    String userIncomeAmount;
    String userRegistrationNumber;

    public UserInfoDto toUserInfoDto(String userKey){
        return new UserInfoDto(userKey, userName, userRegistrationNumber, userIncomeAmount);
    }
}
