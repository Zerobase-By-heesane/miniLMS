package com.zerobase.product.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrganizationCode {
    NONE("NONE", "00000"),
    ORGANIZATION_ONE("ORGANIZATION_ONE", "00001"),
    ORGANIZATION_TWO("ORGANIZATION_TWO", "00002");

    private final String label;
    private final String orgCode;
}
