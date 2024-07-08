package com.zerobase.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_LIST")
public class ProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prod_cd")
    private String productCode;

    @Column(name = "org_cd")
    private String organizationCode;
}
