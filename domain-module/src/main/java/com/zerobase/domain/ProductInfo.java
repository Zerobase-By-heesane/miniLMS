package com.zerobase.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Table(name = "PRODUCT_INFO")
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "org_cd")
    private String organizationCode;

    @Column(name = "prod_cd")
    private String productCode;

    @Column(name = "prod_nm")
    private String productName;

    @Column(name = "prod_min_intr")
    private Double productMinInterest;

    @Column(name = "prod_max_intr")
    private Double productMaxInterest;

}
