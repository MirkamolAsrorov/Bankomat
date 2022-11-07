package com.example.bankomat.payload.requestDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequest {
    @NotNull
    @Size(min = 3, max = 12)
    private String name, midName, lastName;

    @Null
    @Size(min = 8,max = 20)
    private String userPassword;

    @Null
    @Email
    private String email;
}
