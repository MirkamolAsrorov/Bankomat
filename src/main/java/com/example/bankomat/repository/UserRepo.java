package com.example.bankomat.repository;

import com.example.bankomat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
List<User> findAllByActiveTrue();

    Optional<User> findByIdAndActiveTrue(Long bossId);
}
