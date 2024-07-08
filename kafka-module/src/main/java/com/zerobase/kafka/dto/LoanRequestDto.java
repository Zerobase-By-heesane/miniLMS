package com.zerobase.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoanRequestDto {
    private String userKey;
    private String userName;
    private Long userIncomeAmount;
    private String userRegistrationNumber;
}
