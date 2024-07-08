package com.zerobase.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zerobase.kafka.dto.LoanRequestDto;
import com.zerobase.kafka.enums.KafkaTopic;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoanRequestSender {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendMessage(KafkaTopic topic, LoanRequestDto loanRequestDto) throws JsonProcessingException {
        kafkaTemplate.send(topic.getTopicName(), objectMapper.writeValueAsString(loanRequestDto));
    }
}
