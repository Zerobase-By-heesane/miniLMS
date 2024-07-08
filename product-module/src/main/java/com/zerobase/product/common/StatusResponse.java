package com.zerobase.product.common;

import com.zerobase.product.type.ResponseContent;
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
