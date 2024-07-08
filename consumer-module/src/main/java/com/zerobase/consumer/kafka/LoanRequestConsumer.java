package com.zerobase.consumer.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zerobase.consumer.service.LoanRequestService;
import com.zerobase.kafka.dto.LoanRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class LoanRequestConsumer {

    private final ObjectMapper objectMapper;
    private final LoanRequestService loanRequestService;

    @KafkaListener(topics = "loan-request", groupId = "fintech")
    public void consume(String message) throws JsonProcessingException {
        LoanRequestDto loanRequestDto = objectMapper.readValue(message, LoanRequestDto.class);
        loanRequestService.loanRequest(loanRequestDto);
    }
}
