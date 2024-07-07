package com.zerobase.repository;

import com.zerobase.domain.LoanReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanReviewRepository extends JpaRepository<LoanReview, Long>{
    Optional<LoanReview> findByUserKey(String usrKey);
}
