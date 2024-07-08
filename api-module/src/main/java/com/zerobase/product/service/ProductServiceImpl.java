package com.zerobase.product.service;

import com.zerobase.product.dto.ProductResponse;
import com.zerobase.common.model.StatusResponse;
import com.zerobase.domain.ProductInfo;
import com.zerobase.product.dto.ProductDto;
import com.zerobase.product.type.OrganizationCode;
import com.zerobase.common.type.ResponseContent;
import com.zerobase.repository.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductInfoRepository productInfoRepository;

    @Cacheable(value = "PRODUCT", key = "#organizationCode", cacheManager = "redisCacheManager")
    @Override
    public ProductResponse getProduct(OrganizationCode organizationCode) {
        List<ProductInfo> allByOrganizationCode = productInfoRepository.findAllByOrganizationCode(organizationCode.getOrgCode());
        
        if (allByOrganizationCode.isEmpty()) {
            return new ProductResponse(List.of(), ResponseContent.FAIL);
        }
        
        List<ProductDto> productDtos = allByOrganizationCode.stream()
                .map(ProductDto::toDto)
                .toList();
        
        return new ProductResponse(productDtos, ResponseContent.SUCCESS);
    }

    @Override
    public StatusResponse createProduct(ProductDto product) {

        if(productInfoRepository.existsByOrganizationCodeAndProductCode(product.getOrganizationCode(), product.getProductCode())){
            return new StatusResponse(ResponseContent.FAIL);
        }

        ProductInfo productInfo = ProductInfo.builder()
                .organizationCode(product.getOrganizationCode())
                .productCode(product.getProductCode())
                .productMaxInterest(product.getProductMaximumInterest())
                .productMinInterest(product.getProductMinimumInterest())
                .productName(product.getProductName())
                .build();

        productInfoRepository.save(productInfo);

        return new StatusResponse(ResponseContent.SUCCESS);
    }

}
