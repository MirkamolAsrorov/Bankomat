package com.example.bankomat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //
    @Column(nullable = false)
    private String DistrictName;

    @Column(nullable = false, unique = true)
    private String zipCode;

    @Column(nullable = false)
    private boolean active = true;

}
