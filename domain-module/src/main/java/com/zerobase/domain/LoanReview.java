package com.zerobase.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "LOAN_REVIEW")
public class LoanReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자 키
    @Column(name = "usr_key")
    private String userKey;

    // 대출 신청 금액
    @Column(name = "loan_lmt_amt")
    private Long loanLimitedAmount;

    // 이자
    @Column(name = "loan_intrt")
    private Double loanInterest;
}
