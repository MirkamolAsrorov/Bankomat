package com.example.bankomat.payload.responseDTO;

import com.example.bankomat.model.enums.CardTypes;
import com.example.bankomat.payload.BranchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardResponse {
    private Long cardId;
    private String cardNumber;
    private Double cardBalance;
    private String dueDate;
    private CardTypes cardTypes;
    private BranchDto branchDto;
    private UserResponse owner;

}
