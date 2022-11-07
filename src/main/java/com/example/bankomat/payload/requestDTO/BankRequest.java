package com.example.bankomat.payload.requestDTO;

import com.example.bankomat.payload.AddressDto;
import com.example.bankomat.payload.BossDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankRequest {
private String name;
private AddressDto address;
}
