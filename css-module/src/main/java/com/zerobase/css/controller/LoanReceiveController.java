package com.zerobase.css.controller;

import com.zerobase.css.dto.LoanRequestDto;
import com.zerobase.css.dto.LoanResultDto;
import com.zerobase.css.service.LoanReceiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/css/api/v1")
public class LoanReceiveController {

    private final LoanReceiveService loanReceiveService;

    @PostMapping("/request")
    public LoanResultDto.ResponseDto loanReceive(@RequestBody LoanRequestDto.RequestInputDto requestInputDto) {
        log.info("LoanRequestDto: {}", requestInputDto.toString());
        LoanResultDto.ResponseDto responseDto = loanReceiveService.loanReview(requestInputDto);
        log.info("LoanResultDto: {}", responseDto.toString());
        return responseDto;
    }
}
