package com.zerobase.product.dto;

import com.zerobase.common.type.ResponseContent;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ProductResponse {
    private List<ProductDto> data;
    private String code;
    private String responseMessage;

    public ProductResponse(List<ProductDto> data, ResponseContent responseContent) {
        this.data = data;
        this.code = responseContent.getResponseCode();
        this.responseMessage = responseContent.getResponseMessage();
    }
}
