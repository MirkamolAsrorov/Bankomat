package com.example.bankomat.repository;

import com.example.bankomat.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepo extends JpaRepository<Cards,Long> {
    Optional<Cards> findByCardNumber(Long aLong);

    Optional<Cards> findByIdAndActiveTrue(Long aLong);

    List<Cards> findAllByActiveTrue();
}
