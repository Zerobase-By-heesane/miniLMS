package com.zerobase.product.common;

import com.zerobase.product.dto.ProductDto;
import com.zerobase.product.type.ResponseContent;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ProductResponseEntity {
    private List<ProductDto> data;
    private String code;
    private String responseMessage;

    public ProductResponseEntity(List<ProductDto> data, ResponseContent responseContent) {
        this.data = data;
        this.code = responseContent.getResponseCode();
        this.responseMessage = responseContent.getResponseMessage();
    }
}
