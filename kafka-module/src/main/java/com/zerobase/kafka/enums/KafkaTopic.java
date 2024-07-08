package com.zerobase.kafka.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum KafkaTopic {

    LOAN_REQUEST("loan-request");

    private final String topicName;
}
