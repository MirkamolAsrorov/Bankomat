package com.example.bankomat.mappers;

import com.example.bankomat.model.User;
import com.example.bankomat.payload.requestDTO.UserRequest;
import com.example.bankomat.payload.responseDTO.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "userPassword",target = "password")
    User toModel(UserRequest request);

    UserResponse toDto(User user);

    List<UserResponse> toDTOs(List<User> users);

}
