package com.zerobase.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserInputDto {
    public Long userIncomeAmount;
    public String userName;
    public String userRegistrationNumber;
}
