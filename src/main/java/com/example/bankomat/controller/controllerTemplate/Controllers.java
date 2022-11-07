package com.example.bankomat.controller.controllerTemplate;

import org.springframework.http.ResponseEntity;

public interface Controllers {
ResponseEntity<?> getAll();
ResponseEntity<?> getById(Long id);
}
