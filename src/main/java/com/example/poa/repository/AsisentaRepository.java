package com.example.poa.repository;

import com.example.poa.entity.Asistenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsisentaRepository extends JpaRepository<Asistenta, Integer> {
}
