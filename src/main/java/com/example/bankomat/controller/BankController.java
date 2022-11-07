package com.example.bankomat.controller;

import com.example.bankomat.controller.controllerTemplate.Controllers;
import com.example.bankomat.mappers.BankMapper;
import com.example.bankomat.payload.ApiResponse;
import com.example.bankomat.payload.requestDTO.BankRequest;
import com.example.bankomat.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank")
public class BankController implements Controllers {
    private final BankService bankService;


    @GetMapping
    @Override
    public ResponseEntity<?> getAll() {
        ApiResponse apiResponse = bankService.getAll();
        return apiResponse == null ? (ResponseEntity<?>) ResponseEntity.EMPTY
                : ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getById(@PathVariable Long id) {
        ApiResponse apiResponse = bankService.getById(id);
        return apiResponse.isSuccess() ? ResponseEntity.ok(apiResponse) :
                (ResponseEntity<?>) ResponseEntity.notFound();
    }

}
