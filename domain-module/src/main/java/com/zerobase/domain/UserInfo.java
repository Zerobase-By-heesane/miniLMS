package com.zerobase.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "USR_INFO")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usr_key")
    private String userKey;

    @Column(name = "usr_reg_num")
    private String userRegistrationNumber;

    @Column(name = "usr_nm")
    private String userName;

    @Column(name = "usr_icm_amt")
    private Long userIncomeAmount;
}
