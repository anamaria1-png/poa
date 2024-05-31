package com.example.poa.repository;

import com.example.poa.entity.Dentist;
import com.example.poa.entity.Pacient;
import com.example.poa.entity.Programare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramareRepository extends JpaRepository<Programare, Integer> {
    List<Programare> findAllByDentist(Dentist dentist);
    List<Programare> findAllByPacient(Pacient pacient);
}
