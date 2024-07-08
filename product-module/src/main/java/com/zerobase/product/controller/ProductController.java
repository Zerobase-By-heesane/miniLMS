package com.zerobase.product.controller;

import com.zerobase.product.common.ProductResponseEntity;
import com.zerobase.product.common.StatusResponse;
import com.zerobase.product.dto.ProductDto;
import com.zerobase.product.service.ProductService;
import com.zerobase.product.type.OrganizationCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fintech/v1")
@Tag( name ="Product", description = "상품 정보 관련 API")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "상품 정보 조회 API", description = "상품 정보를 조회하는 API")
    @GetMapping("/product/{organizationCode}")
    public ResponseEntity<ProductResponseEntity> getProduct(
            @PathVariable
            @Parameter(description = "기관 코드")
            OrganizationCode organizationCode) {
        return ResponseEntity.ok(productService.getProduct(organizationCode));
    }

    @Operation(summary = "상품 정보 수신 API",description = "금융사로부터 상품 정보를 받는 API")
    @PostMapping("/product/information")
    public ResponseEntity<StatusResponse> createProduct(@RequestBody ProductDto product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }
}
