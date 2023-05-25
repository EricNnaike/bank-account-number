package com.example.bankaccountnumber.service;

import com.example.bankaccountnumber.dto.AccountDto;
import com.example.bankaccountnumber.dto.AccountResponse;
import com.example.bankaccountnumber.entity.Account;
import com.example.bankaccountnumber.entity.Bank;

import java.util.List;

public interface Service {
    List<Bank> getAccountBanks(String accountNumber) throws Exception;
    AccountResponse<?> createAccountWithSerial(AccountDto accountDto) throws Exception;
}
