package com.zerobase.loan.request;

import com.zerobase.domain.UserInfo;
import com.zerobase.kafka.dto.LoanRequestDto;
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
    Long userIncomeAmount;

    public UserInfo toEntity(){
        return UserInfo.builder()
                .userKey(userKey)
                .userName(userName)
                .userRegistrationNumber(userRegistrationNumber)
                .userIncomeAmount(userIncomeAmount)
                .build();
    }

    public LoanRequestDto toLoanRequestKafkaDto(){
        return new LoanRequestDto(
                userKey,
                userName,
                userIncomeAmount,
                userRegistrationNumber
        );
    }
}
