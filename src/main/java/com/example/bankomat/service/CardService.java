package com.example.bankomat.service;

import com.example.bankomat.mappers.CardMapper;
import com.example.bankomat.model.Bank;
import com.example.bankomat.model.Cards;
import com.example.bankomat.model.User;
import com.example.bankomat.model.enums.CardTypes;
import com.example.bankomat.payload.ApiResponse;
import com.example.bankomat.payload.BranchDto;
import com.example.bankomat.payload.CardUpdateDto;
import com.example.bankomat.payload.requestDTO.CardRequest;
import com.example.bankomat.payload.responseDTO.CardResponse;
import com.example.bankomat.repository.BankRepo;
import com.example.bankomat.repository.CardRepo;
import com.example.bankomat.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardService {
    final CardRepo cardRepo;
    final CardMapper cardMapper;

    final UserRepo userRepo;
    final BankRepo bankRepo;

    public String random16DigitForCard(Integer index) {
        Random random = new Random(System.nanoTime());
        Long random9 = Long.valueOf(random.nextInt(1000000000));
        Long random3 = Long.valueOf(random.nextInt(1000));
        String random12 = "" + index + random9 + random3;
        return random12;
    }

    public Integer random3DigitForCvv() {
        Random random = new Random(System.nanoTime());
        Integer random3 = (random.nextInt(1000));
        return random3;
    }


    public ApiResponse getById(Long cardId) {
        Optional<Cards> optional = cardRepo.findById(cardId);
        if (optional.isEmpty())
            return new ApiResponse<>("null", false);

        Cards cards = optional.get();
        CardResponse cardResponse = cardMapper.toDto(cards);
        return ApiResponse.builder().
                message("Here it is").
                success(true).
                data(cardResponse).
                build();

    }

    public ApiResponse getByCardNumber(Long cardNumber) {
        Optional<Cards> optional = cardRepo.findByCardNumber(cardNumber);
        if (optional.isEmpty())
            return new ApiResponse<>("null", false);

        Cards bank = optional.get();
        CardResponse cardResponse = cardMapper.toDto(bank);
        return ApiResponse.builder().
                message("Here it is").
                success(true).
                data(cardResponse).
                build();

    }

    public ApiResponse getAll() {
        List<CardResponse> bankResponses = cardMapper.toDTOs(cardRepo.findAllByActiveTrue());
        return ApiResponse.builder().
                message("Here it is").
                success(true).
                data(bankResponses).
                build();
    }


    public ApiResponse save(Long branchId, CardRequest cardRequest) {
        Optional<Bank> bankOptional = bankRepo.findByIdAndActiveTrue(branchId);
        if (!bankOptional.isPresent()) {
            return new ApiResponse<>("branch is null", false);
        }

        Cards newCard = cardMapper.toModel(cardRequest);
        if (cardRequest.getOwnerId() != null && userRepo.findById(cardRequest.getOwnerId()).isPresent()) {
            Optional<User> userOptional = userRepo.findById(cardRequest.getOwnerId());

            User owner = userOptional.get();

            newCard.setOwner(owner);
        }

        if (!bankOptional.isEmpty()){
            Bank branch = bankOptional.get();
            newCard.setBranch(branch);
        }

        if (!(cardRequest.getCardTypes().name().equals("UZCARD") || cardRequest.getCardTypes().name().equals("HUMO")))
            return new ApiResponse<>("There is not the type of card in our bank", false);

        newCard.setCardNumber(Long.valueOf
                (random16DigitForCard
                        (Integer.parseInt
                                (cardRequest.getCardTypes().getCards()))));

        newCard.setCvv(random3DigitForCvv());

        userRepo.save(newCard.getOwner());
        cardRepo.save(newCard);

        return ApiResponse.builder().
                message("Card is added").
                success(true).
                build();
    }


    public ApiResponse update(Long cardId, CardUpdateDto updateDto) {
        Optional<Cards> cardsOptional = cardRepo.findByIdAndActiveTrue(cardId);

        if (cardsOptional.isEmpty() && updateDto.getPinCode() == null)
            return new ApiResponse("Wrong", false);

        Cards cards = cardsOptional.get();
        cards.setPinCode(updateDto.getPinCode());
        cardRepo.save(cards);
        return ApiResponse.builder().
                message("The card is updated").
                success(true).
                build();
    }


    public ApiResponse delete(Long id) {
        Optional<Cards> cardsOptional = cardRepo.findById(id);
        if (cardsOptional.isEmpty())
            return new ApiResponse<>("null", false);

        Cards cards = cardsOptional.get();
        cards.setActive(false);
        cardRepo.save(cards);

        return ApiResponse.builder().
                message("deleted").
                success(true).
                build();
    }


}
