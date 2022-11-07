package com.example.bankomat.repository;

import com.example.bankomat.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankRepo extends JpaRepository<Bank,Long> {
    List<Bank> findAllByActiveTrue();

    Optional<Bank> findByIdAndActiveTrue(Long aLong);
}
