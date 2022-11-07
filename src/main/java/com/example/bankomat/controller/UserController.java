package com.example.bankomat.controller;

import com.example.bankomat.controller.controllerTemplate.Controllers;
import com.example.bankomat.payload.ApiResponse;
import com.example.bankomat.payload.requestDTO.UserRequest;
import com.example.bankomat.service.UserService;
import com.example.bankomat.service.serviceTemplate.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController implements Controllers {

    private final UserService userService;

    @GetMapping
    @Override
    public ResponseEntity<?> getAll() {
        ApiResponse apiResponse = userService.getAll();
        return apiResponse == null ? (ResponseEntity<?>) ResponseEntity.EMPTY
                : ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getById(@PathVariable Long id) {
        ApiResponse apiResponse = userService.getById(id);
        return apiResponse.isSuccess() ? ResponseEntity.ok(apiResponse) :
                (ResponseEntity<?>) ResponseEntity.notFound();
    }


    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody UserRequest userRequest) {
        ApiResponse apiResponse = userService.save(userRequest);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ApiResponse apiResponse = userService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }
}

