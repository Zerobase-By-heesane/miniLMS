package com.zerobase.product.dto;

import com.zerobase.domain.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductDto{
    private String organizationCode;
    private String productCode;
    private Double productMaximumInterest;
    private Double productMinimumInterest;
    private String productName;

    public static ProductDto toDto(ProductInfo productInfo){
        return ProductDto.builder()
                .organizationCode(productInfo.getOrganizationCode())
                .productCode(productInfo.getProductCode())
                .productMaximumInterest(productInfo.getProductMaxInterest())
                .productMinimumInterest(productInfo.getProductMinInterest())
                .productName(productInfo.getProductName())
                .build();
    }
}
