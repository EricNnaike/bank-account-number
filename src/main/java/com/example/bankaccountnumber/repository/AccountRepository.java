package com.example.bankaccountnumber.repository;

import com.example.bankaccountnumber.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountBySerial(String serial);
}
