package com.example.bankomat.payload.requestDTO;

import com.example.bankomat.model.enums.CardTypes;
import com.example.bankomat.payload.BranchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardRequest {
    @Null
    private Long ownerId;
    @Null
    private UserRequest owner;

    @NotNull
    @Size(min = 4,max = 4,message = "The pin code must be 4 digits")
    private Integer pinCode;

    @NotNull
    private CardTypes cardTypes;



}
