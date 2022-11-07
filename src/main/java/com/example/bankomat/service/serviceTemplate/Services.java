package com.example.bankomat.service.serviceTemplate;

import com.example.bankomat.payload.ApiResponse;

public interface Services {
ApiResponse getById(Long id);
ApiResponse getAll();
}
