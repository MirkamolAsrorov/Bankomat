package com.example.bankomat.model.enums;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

import static com.example.bankomat.model.enums.BankNotes.*;

@Getter
@ToString
public enum Currencies {
    SUM(Sets.newHashSet(
            BESMING, ELIKMING,
            MING, YIGIRMAMING,
            UNMING, YUZMING)),
//
    USD(Sets.newHashSet(BankNotes.One,
            BankNotes.FIVE,
            BankNotes.TEN,
            BankNotes.FIFTY,
            BankNotes.HUNDRED));
    private Set<BankNotes> notes;

    Currencies(Set<BankNotes> notes) {
        this.notes = notes;
    }
}
