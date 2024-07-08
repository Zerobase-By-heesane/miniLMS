package com.zerobase.product.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseContent {
    SUCCESS("00", "success"),
    FAIL("01", "fail");

    private final String responseCode;
    private final String responseMessage;

}
