package com.example.poa.service;

import com.example.poa.entity.Pacient;
import com.example.poa.exception.BadRequestException;
import com.example.poa.exception.ConflictingDataException;
import com.example.poa.repository.PacientRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PacientService {
    private final PacientRepository pacientRepository;

    public PacientService(PacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    public List<Pacient> obtineTotiPacientii() {
        return pacientRepository.findAll().stream().sorted(Comparator.comparing(Pacient::getNume)).toList();
    }

    public Pacient adaugaPacient(Pacient pacient) {
        pacient.setId(null);

        if (pacient.getNume().isBlank()) {
            throw new BadRequestException();
        }
        if (pacient.getCnp().isBlank() || pacient.getCnp().contains("[0-9]+") || pacient.getCnp().length() != 13) {
            throw new BadRequestException();
        }
        if (pacientRepository.findByCnpIgnoreCase(pacient.getCnp()).isPresent()) {
            throw new ConflictingDataException();
        }

        return pacientRepository.save(pacient);
    }
}
