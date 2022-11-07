package com.example.bankomat.mappers;

import com.example.bankomat.model.Atm;
import com.example.bankomat.payload.requestDTO.AtmRequest;
import com.example.bankomat.payload.responseDTO.AtmResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AtmMapper {
    @Mapping(source = "newAdmin",target = "adminForAtm")
    Atm from(AtmRequest request);

    @Mapping(source ="adminForAtm",target = "admin")
    AtmResponse from(Atm atm);

    List<AtmResponse> from(List<Atm> atm);

}
