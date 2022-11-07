package com.example.bankomat.model;

import com.example.bankomat.model.enums.BankNotes;
import com.example.bankomat.model.enums.CardTypes;
import com.example.bankomat.model.enums.Currencies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.example.bankomat.model.enums.BankNotes.*;
import static com.example.bankomat.model.enums.CardTypes.*;
import static com.example.bankomat.model.enums.Currencies.SUM;
import static com.example.bankomat.model.enums.Currencies.USD;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Atm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection()
    @Enumerated(EnumType.STRING)
    private Set<Currencies> currenciesList = new HashSet<>(Arrays.asList(SUM,USD));

    @ElementCollection()
    @Enumerated(EnumType.STRING)
    private Set<BankNotes> bankNotesList = new HashSet<>(
            Arrays.asList(MING,BESMING,UNMING,YIGIRMAMING, ELIKMING,YUZMING));

    @ElementCollection()
    @Enumerated(EnumType.STRING)
    private Set<CardTypes> cardTypesList = new HashSet<CardTypes>(Arrays.asList(VISA,UZCARD,HUMO));

    @ManyToOne
    private Bank branch;

    @OneToOne
    private Addresses address;

    @OneToOne
    private User adminForAtm;

    private Integer sumBalance;

    private Integer dollarBalance;

    @Column(nullable = false)
    private Double commission = 1.0;

    @Column(nullable = false)
    private Integer NumberOF1000sum = 3000; //3 million sums

    @Column(nullable = false)
    private Integer NumberOF5000sum = 2000; //10 million sums

    @Column(nullable = false)
    private Integer NumberOF10000sum=2000; //20 million sums

    @Column(nullable = false)
    private Integer NumberOF50000sum = 1000; //50 million sums

    @Column(nullable = false)
    private Integer NumberOF100000sum = 500; //50 million sums

    @Column(nullable = false)
    private Integer NumberOF1$ = 3000;
    @Column(nullable = false)
    private Integer NumberOF5$ = 2000;

    @Column(nullable = false)
    private Integer NumberOF10$ = 2000;

    @Column(nullable = false)
    private Integer NumberOF20$ = 1000;

    @Column(nullable = false)
    private Integer NumberOF50$ = 500;

    @Column(nullable = false)
    private Integer NumberOF100$ = 10;

    @Column(nullable = false)
    private boolean active = true;
}
