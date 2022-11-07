package com.example.bankomat.service;

import com.example.bankomat.mappers.AtmMapper;
import com.example.bankomat.model.Atm;
import com.example.bankomat.model.Bank;
import com.example.bankomat.model.User;
import com.example.bankomat.payload.ApiResponse;
import com.example.bankomat.payload.requestDTO.AtmRequest;
import com.example.bankomat.payload.responseDTO.AtmResponse;
import com.example.bankomat.repository.AddressRepo;
import com.example.bankomat.repository.AtmRepo;
import com.example.bankomat.repository.BankRepo;
import com.example.bankomat.repository.UserRepo;
import com.example.bankomat.service.serviceTemplate.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AtmService implements Services {
    private final UserRepo userRepo;
    private final AtmRepo atmRepo;
    private final AtmMapper atmMapper;
    private final BankRepo bankRepo;

    private final AddressRepo addressRepo;

    @Override
    public ApiResponse getById(Long id) {
        Optional<Atm> atmOptional = atmRepo.findById(id);
        if (atmOptional.isEmpty())
            return new ApiResponse<>("null", false);

        Atm atm = atmOptional.get();
        AtmResponse atmResponse = atmMapper.from(atm);
        return ApiResponse.builder().
                message("Here it is").
                success(true).
                data(atmResponse).
                build();
    }

    @Override
    public ApiResponse getAll() {
        List<AtmResponse> atmResponses = atmMapper.from(atmRepo.findAllByActiveTrue());
        return ApiResponse.builder().
                message("Here it is").
                success(true).
                data(atmResponses).
                build();

    }


    public ApiResponse save(Long branchId, AtmRequest atmRequest) {
        Optional<Bank> bankOptional = bankRepo.findByIdAndActiveTrue(branchId);

        if (bankOptional.isEmpty()) {
            return new ApiResponse("Not Found", false);
        }

        Bank branch = bankOptional.get();
        Double branchSumBalance = branch.getSumBalance();
        Integer branchDollarBalance = branch.getDollarBalance();

        Atm atm = atmMapper.from(atmRequest);
        atm.setBranch(branch);

        Integer capitalSum = sumBalance(
                atm.getNumberOF1000sum(), atm.getNumberOF5000sum(),
                atm.getNumberOF10000sum(), atm.getNumberOF50000sum(), atm.getNumberOF100000sum());

        Integer capital$ = dollarBalance(
                atm.getNumberOF1$(), atm.getNumberOF5$(),
                atm.getNumberOF10$(),atm.getNumberOF50$(),atm.getNumberOF100$());

        if (capitalSum > branchSumBalance) {
            return new ApiResponse<>("Not enough sum  in the Branch", false);
        }
        branch.setSumBalance(branchSumBalance - capitalSum);
        atm.setSumBalance(capitalSum);

        if (capital$ > branchDollarBalance){
            return new ApiResponse<>("Not enough Dollar money in the Branch", false);
        }
        branch.setDollarBalance(branchDollarBalance - capital$);
        atm.setDollarBalance(capital$);

        Optional<User> userOptional = userRepo.findByIdAndActiveTrue(atmRequest.getAdminId());
        if (atmRequest.getAdminId() != null && userOptional.isPresent()) {
            atm.setAdminForAtm(userOptional.get());
        }
        addressRepo.save(atm.getAddress());
        userRepo.save(atm.getAdminForAtm());
        atmRepo.save(atm);
        bankRepo.save(branch);
        return ApiResponse.builder().
                message("Atm is added").
                success(true).
                build();
    }

    public static Integer sumBalance(Integer thousand, Integer fiveThousand,
                                        Integer tenThousand, Integer fiftyThousand, Integer hundredThousand) {
        return thousand * 1000 + fiveThousand * 5000 +
                tenThousand * 10000 + fiftyThousand * 50000 + hundredThousand * 100000;
    }
    public static Integer dollarBalance(Integer one$, Integer five$,
                                    Integer ten$, Integer fifty$, Integer hundred$) {
        return  one$ * 1 + five$ * 5 +
                ten$ * 10 + fifty$ * 5 +hundred$ * 100;
    }


    public ApiResponse update(AtmRequest atmRequest) {
        Optional<Atm> optionalAtm = atmRepo.findByIdAndActiveTrue(atmRequest.getId());
        if (!optionalAtm.isPresent()) {
            return new ApiResponse<>("Not found", false);
        }
        Optional<User> userOptional = userRepo.findByIdAndActiveTrue(atmRequest.getAdminId());
        Atm atm = atmMapper.from(atmRequest);
        atm.setBranch(optionalAtm.get().getBranch());
        if (atmRequest.getAdminId() != null && userOptional.isPresent()) {
            atm.setAdminForAtm(userOptional.get());
        }
        addressRepo.save(atm.getAddress());
        userRepo.save(atm.getAdminForAtm());
        Atm save = atmRepo.save(atm);

        return ApiResponse.builder().
                message("Atm.is updated").
                success(true).
                data(save).
                build();
    }


    public ApiResponse delete(Long id) {
        Optional<Atm> optionalAtm = atmRepo.findByIdAndActiveTrue(id);
        if (!optionalAtm.isPresent()) {
            return new ApiResponse<>("Not found", false);
        }
        Atm atm = optionalAtm.get();
        atm.setActive(false);
        atmRepo.save(atm);
        return ApiResponse.builder().
                message("Atm.is deleted").
                success(true).
                build();
    }

}
