package com.example.bankaccountnumber.utils;

import com.example.bankaccountnumber.entity.Bank;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BankCodes {

    public static final List<Bank> banks = new ArrayList<>();

    static {
        banks.add(new Bank("ACCESS BANK", "044"));
        banks.add(new Bank("CITIBANK", "023"));
        banks.add(new Bank("DIAMOND BANK", "063"));
        banks.add(new Bank("ECOBANK NIGERIA", "050"));
        banks.add(new Bank("FIDELITY BANK", "070"));
        banks.add(new Bank("FIRST BANK OF NIGERIA", "011"));
        banks.add(new Bank("FIRST CITY MONUMENT BANK", "214"));
        banks.add(new Bank("GUARANTY TRUST BANK", "058"));
        banks.add(new Bank("HERITAGE BANK", "030"));
        banks.add(new Bank("JAIZ BANK", "301"));
        banks.add(new Bank("KEYSTONE BANK", "082"));
        banks.add(new Bank("PROVIDUS BANK", "101"));
        banks.add(new Bank("SKYE BANK", "076"));
        banks.add(new Bank("STANBIC IBTC BANK", "221"));
        banks.add(new Bank("STANDARD CHARTERED BANK", "068"));
        banks.add(new Bank("STERLING BANK", "232"));
        banks.add(new Bank("SUNTRUST", "100"));
        banks.add(new Bank("UNION BANK OF NIGERIA", "032"));
        banks.add(new Bank("UNITED BANK FOR AFRICA", "033"));
        banks.add(new Bank("UNITY BANK", "215"));
        banks.add(new Bank("WEMA BANK", "035"));
        banks.add(new Bank("ZENITH BANK", "057"));
    }

}
