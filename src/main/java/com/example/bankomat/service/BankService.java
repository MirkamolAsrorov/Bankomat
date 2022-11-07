package com.example.bankomat.service;

import com.example.bankomat.mappers.BankMapper;
import com.example.bankomat.model.Bank;
import com.example.bankomat.payload.ApiResponse;
import com.example.bankomat.payload.responseDTO.BankResponse;
import com.example.bankomat.repository.AddressRepo;
import com.example.bankomat.repository.BankRepo;
import com.example.bankomat.repository.UserRepo;
import com.example.bankomat.service.serviceTemplate.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankService implements Services {

    private final BankRepo bankRepo;
    private final BankMapper bankMapper;

    private final AddressRepo addressRepo;
    private final UserRepo userRepo;
    @Override
    public ApiResponse getById(Long id) {
        Optional<Bank> bankOptional = bankRepo.findById(id);
        if (bankOptional.isEmpty())
            return new ApiResponse<>("null", false);

        Bank bank = bankOptional.get();
        BankResponse bankResponse = bankMapper.toDto(bank);
        return ApiResponse.builder().
                message("Here it is").
                success(true).
                data(bankResponse).
                build();

    }

    @Override
    public ApiResponse getAll() {
        List<BankResponse> bankResponses = bankMapper.toDTOs(bankRepo.findAllByActiveTrue());
        return ApiResponse.builder().
                message("Here it is").
                success(true).
                data(bankResponses).
                build();
    }



//    public ApiResponse save(Long bossId,BankRequest request) {
//        Optional<User> userOptional = userRepo.findByIdAndActiveTrue(bossId);
//        if (userOptional.isEmpty()) {
//            return new ApiResponse<>("null",false);
//        }
//
//        /**
//         * if I do not code setActive and setBalance,
//         * There will be null in active and balance in the bank's table.
//         */
//        Bank bank = bankMapper.toModel(request);
//        bank.setBoss(userOptional.get());
//        bank.setActive(true);
//        bank.setBalance(100000000000.0);
//
//        addressRepo.save(bank.getAddress());
//        Bank save = bankRepo.save(bank);
//        return bank == null || save == null ?
//                new ApiResponse<>("The bank is not added", false) :
//                ApiResponse.builder().
//                        message("Added").
//                        success(true).
//                        build();
//    }


}

