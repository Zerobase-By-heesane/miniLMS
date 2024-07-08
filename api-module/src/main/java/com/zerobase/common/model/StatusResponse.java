package com.zerobase.common.model;

import com.zerobase.common.type.ResponseContent;
import lombok.Getter;

@Getter
public class StatusResponse {
    private final String responseCode;
    private final String responseMessage;

    public StatusResponse(ResponseContent responseContent) {
        this.responseCode = responseContent.getResponseCode();
        this.responseMessage = responseContent.getResponseMessage();
    }
}
