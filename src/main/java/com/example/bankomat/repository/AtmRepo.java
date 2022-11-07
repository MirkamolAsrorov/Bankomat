package com.example.bankomat.repository;

import com.example.bankomat.model.Atm;
import com.example.bankomat.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AtmRepo extends JpaRepository<Atm,Long> {
    Optional<Atm> findByIdAndActiveTrue(Long aLong);

    List<Atm> findAllByActiveTrue();
}
