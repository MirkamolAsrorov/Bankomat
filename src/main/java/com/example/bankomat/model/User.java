package com.example.bankomat.model;

import com.example.bankomat.abstracts.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name = "users")
public class User extends AbsNameEntity {

    private String midName, lastName, password;
    @Column(unique = true)
    @Email
    private String email;


}
