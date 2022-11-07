package com.example.bankomat.repository;

import com.example.bankomat.model.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Addresses,Long> {
}
