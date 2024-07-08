package com.zerobase.css.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
public class LoanRequestDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @ToString
    public static class RequestInputDto {
        String userKey;
        String userName;
        Long userIncomeAmount;
        String userRegistrationNumber;
    }
}
