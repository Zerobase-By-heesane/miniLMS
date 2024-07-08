package com.zerobase.product.service;

import com.zerobase.domain.ProductInfo;
import com.zerobase.product.common.ProductResponseEntity;
import com.zerobase.product.common.StatusResponse;
import com.zerobase.product.dto.ProductDto;
import com.zerobase.product.type.OrganizationCode;
import com.zerobase.product.type.ResponseContent;
import com.zerobase.repository.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductInfoRepository productInfoRepository;

    @Override
    public ProductResponseEntity getProduct(OrganizationCode organizationCode) {
        List<ProductInfo> allByOrganizationCode = productInfoRepository.findAllByOrganizationCode(organizationCode.getOrgCode());
        
        if (allByOrganizationCode.isEmpty()) {
            return new ProductResponseEntity(List.of(), ResponseContent.FAIL);
        }
        
        List<ProductDto> productDtos = allByOrganizationCode.stream()
                .map(ProductDto::toDto)
                .toList();
        
        return new ProductResponseEntity(productDtos, ResponseContent.SUCCESS);
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
