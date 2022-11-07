package com.example.bankomat.model;

import com.example.bankomat.abstracts.AbsNameEntity;
import com.example.bankomat.model.enums.CardTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.example.bankomat.model.enums.CardTypes.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity
public class Bank extends AbsNameEntity {
    @OneToOne
    private Addresses address;
    @OneToOne
    private User boss;

    @ElementCollection()
    @Enumerated(EnumType.STRING)
    private Set<CardTypes> supportCards = new HashSet<CardTypes>(Arrays.asList(VISA,UZCARD,HUMO));

    @Column(nullable = false)
    private Double sumBalance =65896860000.000;

    @Column(nullable = false)
    private Integer dollarBalance=6000000;

}
