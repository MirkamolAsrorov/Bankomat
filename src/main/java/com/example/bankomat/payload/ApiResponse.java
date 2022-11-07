package com.example.bankomat.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse <T> {
private String message;
private boolean success;
private T data;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
