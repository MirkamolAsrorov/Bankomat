package com.example.bankomat.mappers;

import com.example.bankomat.model.Cards;
import com.example.bankomat.payload.CardUpdateDto;
import com.example.bankomat.payload.requestDTO.CardRequest;
import com.example.bankomat.payload.responseDTO.CardResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CardMapper {

    @ValueMapping(source = "cardTypes",target = "cardTypes")
    Cards toModel(CardRequest request);

    Cards toModel(CardUpdateDto cardUpdateDto);
    @Mapping(source = "id",target = "cardId")
    @Mapping(source = "balance",target = "cardBalance")
    @Mapping(source = "branch",target = "branchDto")
    CardResponse toDto(Cards cards);

    List<CardResponse> toDTOs(List<Cards> cardsList);
}
