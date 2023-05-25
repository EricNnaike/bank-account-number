package com.example.bankaccountnumber.controller;

import com.example.bankaccountnumber.dto.AccountDto;
import com.example.bankaccountnumber.dto.AccountResponse;
import com.example.bankaccountnumber.entity.Account;
import com.example.bankaccountnumber.entity.Bank;
import com.example.bankaccountnumber.service.Service;
import com.example.bankaccountnumber.service.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "**")
public class AccountController {

    private final Service service;

    @GetMapping("/account-details")
    public List<Bank> getAccountBanks(@RequestParam String accountNumber) throws Exception {
        return service.getAccountBanks(accountNumber);
    }

    @PostMapping("/create-account")
    public ResponseEntity<AccountResponse> createAccountWithSerial(@RequestBody AccountDto accountDto) throws Exception {
        return new ResponseEntity<>(service.createAccountWithSerial(accountDto), HttpStatus.OK);
    }




}
