package com.zerobase.css.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class LoanResultDto {

    @Getter
    @AllArgsConstructor
    @ToString
    public static class ResponseDto {
        String userKey;
        Long limitAmount;
        Double interest;
    }
}
