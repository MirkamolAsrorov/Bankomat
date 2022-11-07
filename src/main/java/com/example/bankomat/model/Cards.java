package com.example.bankomat.model;

import com.example.bankomat.model.enums.CardTypes;
import com.example.bankomat.service.CardService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private Long cardNumber;

    @Column(nullable = false,unique = true)
    private Integer cvv;

    private LocalDate issueDate = LocalDate.now();

    @Column(nullable = false, updatable = false)
    private LocalDate dueDate = issueDate.plusYears(2);


    @Column(nullable = false)
    private CardTypes cardTypes;

    @Column(nullable = false)
    private Integer pinCode;

    @Column(nullable = false)
    private Double balance= 0.0;

    private Integer countMissCode =0;

    @OneToOne
    private User owner;

    @ManyToOne
    private Bank branch;

    @Column(nullable = false)
    private boolean active = true;

}
