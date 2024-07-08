package com.zerobase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductList extends JpaRepository<ProductList, Long>{
}
