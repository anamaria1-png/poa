package com.example.poa.repository;

import com.example.poa.entity.Specializare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecializareRepository extends JpaRepository<Specializare, Integer> {
    Optional<Specializare> findByNumeIgnoreCase(String nume);
}
