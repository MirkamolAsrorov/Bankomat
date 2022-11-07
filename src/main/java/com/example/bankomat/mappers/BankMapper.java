package com.example.bankomat.mappers;

import com.example.bankomat.model.Bank;
import com.example.bankomat.payload.requestDTO.BankRequest;
import com.example.bankomat.payload.responseDTO.BankResponse;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface BankMapper {

    Bank toModel(BankRequest bankRequest);

    BankResponse toDto(Bank bank);

    List<BankResponse> toDTOs(List<Bank> bankList);
}
