package com.zerobase.product.service;

import com.zerobase.product.common.ProductResponseEntity;
import com.zerobase.product.common.StatusResponse;
import com.zerobase.product.dto.ProductDto;
import com.zerobase.product.type.OrganizationCode;

public interface ProductService {
    ProductResponseEntity getProduct(OrganizationCode organizationCode);
    StatusResponse createProduct(ProductDto product);
}
