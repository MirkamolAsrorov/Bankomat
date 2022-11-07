package com.example.bankomat.payload.responseDTO;

import com.example.bankomat.payload.AbsNameDto;
import com.example.bankomat.payload.AddressDto;
import com.example.bankomat.payload.BossDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class BankResponse extends AbsNameDto {
    private AddressDto address;
    private UserResponse boss;
}
