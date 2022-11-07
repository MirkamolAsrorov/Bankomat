package com.example.bankomat.payload.responseDTO;

import com.example.bankomat.payload.AddressDto;
import com.example.bankomat.payload.BossDto;
import com.example.bankomat.payload.BranchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtmResponse {
    private Long id;
    private Integer sumBalance;
    private Integer dollarBalance;
    private BossDto admin;
    private BranchDto branch;
    private AddressDto address;
}
