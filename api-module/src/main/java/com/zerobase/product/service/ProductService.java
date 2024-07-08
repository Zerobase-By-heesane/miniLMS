package com.zerobase.product.service;


import com.zerobase.product.dto.ProductResponse;
import com.zerobase.common.model.StatusResponse;
import com.zerobase.product.dto.ProductDto;
import com.zerobase.product.type.OrganizationCode;

public interface ProductService {
    ProductResponse getProduct(OrganizationCode organizationCode);
    StatusResponse createProduct(ProductDto product);
}
