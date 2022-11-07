package com.example.bankomat.model.enums;

public enum BankNotes {
    MING("1000"), BESMING("5000"), UNMING("10000"), YIGIRMAMING("20000"),
    ELIKMING("50000"), YUZMING("100000"),

    One("1$"), FIVE("5$"), TEN("10$"),FIFTY("50$"), HUNDRED("100$");
    private final String bankNotes;
//
    BankNotes(String bankNotes) {
        this.bankNotes = bankNotes;
    }
}
