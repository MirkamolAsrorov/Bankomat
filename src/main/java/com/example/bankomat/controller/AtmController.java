package com.example.bankomat.controller;

import com.example.bankomat.controller.controllerTemplate.Controllers;
import com.example.bankomat.payload.ApiResponse;
import com.example.bankomat.payload.requestDTO.AtmRequest;
import com.example.bankomat.service.AtmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/atms")
@RequiredArgsConstructor
@RestController
public class AtmController implements Controllers {
    private final AtmService atmService;

    @GetMapping
    @Override
    public ResponseEntity<?> getAll() {
        ApiResponse apiResponse = atmService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 404).body(apiResponse);
    }


    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getById(Long id) {
        ApiResponse apiResponse = atmService.getById(id);
        return apiResponse.isSuccess() ? ResponseEntity.ok(apiResponse) :
                (ResponseEntity<?>) ResponseEntity.notFound();
    }

    @PostMapping("/add/atm")
    public ResponseEntity<?> add(@RequestParam(name = "branchId")
                                 Long branchId, @RequestBody AtmRequest atmRequest) {
        ApiResponse apiResponse = atmService.save(branchId, atmRequest);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/update/atm")
    public ResponseEntity<?> update(@RequestBody AtmRequest atmRequest){
        ApiResponse apiResponse = atmService.update(atmRequest);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        ApiResponse apiResponse = atmService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }
}

