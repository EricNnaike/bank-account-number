package com.example.bankaccountnumber.service;

import com.example.bankaccountnumber.dto.AccountDto;
import com.example.bankaccountnumber.dto.AccountResponse;
import com.example.bankaccountnumber.entity.Account;
import com.example.bankaccountnumber.entity.Bank;
import com.example.bankaccountnumber.exception.NotFoundError;
import com.example.bankaccountnumber.repository.AccountRepository;
import com.example.bankaccountnumber.utils.BankCodes;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceImpl implements Service {

    private final AccountRepository accountRepository;

    private static final String[] seed = {"3", "7", "3", "3", "7", "3", "3", "7", "3", "3"};
    private static final int nubanLength = 10;
    private static final int serialNumLength = 7;

    @Override
    public List<Bank> getAccountBanks(String accountNumber) throws Exception {
        List<Bank> banks = BankCodes.banks;
        List<Bank> accountBanks = new ArrayList<>();
        for (Bank bank : banks) {
            if (isBankAccountValid(accountNumber, bank.getCode())) {
                accountBanks.add(bank);
            }
        }
        return accountBanks;
    }

    @Override
    public AccountResponse<?> createAccountWithSerial(AccountDto accountDto) throws Exception {
        List<Bank> banks = BankCodes.banks;
        Bank bank = banks.stream()
                .filter(b -> b.getCode().equals(accountDto.getBankCode()))
                .findFirst()
                .orElse(null);

        if (bank == null) {
            return new AccountResponse<>("Bank code not found", null);
        }

        String nuban = "";
        if (accountDto.getSerial().length() != 7L) {
            return new AccountResponse<>("Serial number must be equal to 7", null);
        }

        String padd = accountDto.getSerial() + generateCheckDigit(accountDto.getSerial(), accountDto.getBankCode());
        String after = String.format("%09d", Long.parseLong(padd));
        nuban = String.format("%d09", Long.parseLong(after));

        Account serial = accountRepository.findAccountBySerial(accountDto.getSerial());
        if (serial != null) {
            return new AccountResponse<>("Serial number already exists", null);
        }

        Account account = new Account();
        account.setAccount_number(nuban);
        account.setSerial(accountDto.getSerial());
        account.setBank_code(accountDto.getBankCode());
        account.setBank_name(bank.getName());

        accountRepository.save(account);

        return new AccountResponse<>("success", account);
    }


    private static int generateCheckDigit(String serialNumber, String bankCode) throws Exception {
        if (serialNumber.length() > serialNumLength) {
            throw new NotFoundError("Serial number should be at most " + serialNumLength + "-digits long.");
        }

        String cipher = bankCode + serialNumber;
        int sum = 0;

        for (int i = 0; i < cipher.length(); i++) {
            sum += Character.getNumericValue(cipher.charAt(i)) * Integer.parseInt(seed[i]);
        }
        sum %= 10;

        int checkDigit = 10 - sum;

        checkDigit = (checkDigit == 10) ? 0 : checkDigit;

        return checkDigit;
    }

    public static boolean isBankAccountValid(String accountNumber, String bankCode) throws Exception {
        if (accountNumber == null || accountNumber.length() != nubanLength) {
            throw new NotFoundError("NUBAN must be "+ nubanLength+" digits long");
        }
        String serialNumber = accountNumber.substring(0, 7);
        int checkDigit = generateCheckDigit(serialNumber, bankCode);

        return checkDigit == Character.getNumericValue(accountNumber.charAt(7));
    }

}
