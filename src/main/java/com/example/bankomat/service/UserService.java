package com.example.bankomat.service;

import com.example.bankomat.mappers.UserMapper;
import com.example.bankomat.model.User;
import com.example.bankomat.payload.ApiResponse;
import com.example.bankomat.payload.requestDTO.UserRequest;
import com.example.bankomat.payload.responseDTO.UserResponse;
import com.example.bankomat.repository.UserRepo;
import com.example.bankomat.service.serviceTemplate.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements Services {
    private final UserRepo userRepo;
    private final UserMapper userMapper;


    @Override
    public ApiResponse getById(Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty())
            return new ApiResponse<>("null", false);

        User user = userOptional.get();
        UserResponse userResponse = userMapper.toDto(user);
        return ApiResponse.builder().
                message("Here it is").
                success(true).
                data(userResponse).
                build();
    }

    @Override
    public ApiResponse getAll() {
        List<UserResponse> userResponses = userMapper.toDTOs(userRepo.findAllByActiveTrue());
        return ApiResponse.builder().
                message("Here it is").
                success(true).
                data(userResponses).
                build();
    }


    public ApiResponse save(UserRequest request) {
        User user = userMapper.toModel(request);
        user.setActive(true);  //exception
        User save = userRepo.save(user);
        return user == null || save == null ?
                new ApiResponse<>("The user is not added", false) :
                ApiResponse.builder().
                        message("Added").
                        success(true).
                        build();
    }


    public ApiResponse delete(Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty())
            return new ApiResponse<>("null", false);

        User user = userOptional.get();
        user.setActive(false);
        return ApiResponse.builder().
                message("deleted").
                success(true).
                build();
    }


}
