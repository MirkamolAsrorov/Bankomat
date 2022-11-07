package com.example.bankomat.controller;

import com.example.bankomat.controller.controllerTemplate.Controllers;
import com.example.bankomat.payload.ApiResponse;
import com.example.bankomat.payload.CardUpdateDto;
import com.example.bankomat.payload.requestDTO.CardRequest;
import com.example.bankomat.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cards")
@RequiredArgsConstructor
@RestController
public class CardController implements Controllers {
    private final CardService cardService;


    @GetMapping
    @Override
    public ResponseEntity<?> getAll() {
        ApiResponse apiResponse = cardService.getAll();
        return apiResponse == null ? (ResponseEntity<?>) ResponseEntity.EMPTY
                : ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/cardNumber")
    public ResponseEntity<?> getBYCardNumber(@RequestParam(name = "cardNumber") Long cardNumber) {
        ApiResponse apiResponse = cardService.getByCardNumber(cardNumber);
        return apiResponse.isSuccess() ? ResponseEntity.ok(apiResponse) :
                (ResponseEntity<?>) ResponseEntity.notFound();
    }

    @GetMapping("/card/{id}")
    @Override
    public ResponseEntity<?> getById(@PathVariable Long id) {
        ApiResponse apiResponse = cardService.getById(id);
        return apiResponse.isSuccess() ? ResponseEntity.ok(apiResponse) :
                (ResponseEntity<?>) ResponseEntity.notFound();
    }

    @PostMapping("/add/card")
    public ResponseEntity<?> add(
            @RequestParam(name = "bankId") Long branchId,
            @RequestBody CardRequest cardRequest) {
        ApiResponse apiResponse = cardService.save(branchId, cardRequest);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/update/card/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CardUpdateDto updateDto) {
        ApiResponse apiResponse = cardService.update(id, updateDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @DeleteMapping("delete/card/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ApiResponse apiResponse = cardService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }
}
