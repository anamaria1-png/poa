package com.example.poa.repository;

import com.example.poa.entity.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, Integer> {
    Optional<Pacient> findByCnpIgnoreCase(String cnp);
}
