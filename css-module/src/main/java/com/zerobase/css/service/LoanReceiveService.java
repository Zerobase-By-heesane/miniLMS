package com.zerobase.css.service;

import com.zerobase.css.dto.LoanRequestDto;
import com.zerobase.css.dto.LoanResultDto;
import org.springframework.stereotype.Service;

@Service
public class LoanReceiveService {
    public LoanResultDto.ResponseDto loanReview(LoanRequestDto.RequestInputDto requestInputDto) {
        if(requestInputDto.getUserIncomeAmount() < 0){
            throw new IllegalArgumentException("소득이 0보다 작을 수 없습니다.");
        }

        if(requestInputDto.getUserIncomeAmount() < 10000000){return new LoanResultDto.ResponseDto(requestInputDto.getUserKey(), 10000000L, 0.0);}
        if(requestInputDto.getUserIncomeAmount() < 20000000){return new LoanResultDto.ResponseDto(requestInputDto.getUserKey(), 20000000L, 10.0);}
        if(requestInputDto.getUserIncomeAmount() < 30000000){return new LoanResultDto.ResponseDto(requestInputDto.getUserKey(), 30000000L, 9.0);}
        if(requestInputDto.getUserIncomeAmount() < 40000000){return new LoanResultDto.ResponseDto(requestInputDto.getUserKey(), 40000000L, 8.0);}
        if(requestInputDto.getUserIncomeAmount() < 50000000){return new LoanResultDto.ResponseDto(requestInputDto.getUserKey(), 50000000L, 7.0);}
        if(requestInputDto.getUserIncomeAmount() >= 50000000){return new LoanResultDto.ResponseDto(requestInputDto.getUserKey(), 60000000L, 6.0);}
        throw  new RuntimeException("대출한도를 계산할 수 없습니다.");

    }
}
