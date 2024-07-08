package com.zerobase.repository;

import com.zerobase.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {
    List<ProductInfo> findAllByOrganizationCode(String organizationCode);

    boolean existsByOrganizationCodeAndProductCode(String organizationCode, String productCode);
}
