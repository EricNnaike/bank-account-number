package com.example.bankaccountnumber.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance = new BigDecimal(0.00);

    private String account_number;

    private String bank_name;

    private String bank_code;

    private String serial;

    public Account(String account_number, String bank_name, String bank_code, String serial) {
        this.account_number = account_number;
        this.bank_name = bank_name;
        this.bank_code = bank_code;
        this.serial = serial;
    }
}
