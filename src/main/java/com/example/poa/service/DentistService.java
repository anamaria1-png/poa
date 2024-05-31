package com.example.poa.service;

import com.example.poa.entity.Dentist;
import com.example.poa.exception.BadRequestException;
import com.example.poa.repository.DentistRepository;
import com.example.poa.repository.SpecializareRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DentistService {
    private final DentistRepository dentistRepository;
    private final SpecializareRepository specializareRepository;

    public DentistService(DentistRepository dentistRepository, SpecializareRepository specializareRepository) {
        this.dentistRepository = dentistRepository;
        this.specializareRepository = specializareRepository;
    }

    public List<Dentist> obtineTotiDentistii() {
        return dentistRepository.findAll().stream().sorted(Comparator.comparing(Dentist::getNume)).toList();
    }

    public Dentist adaugaDentist(Dentist dentist) {
        dentist.setId(null);

        if (dentist.getNume().isBlank()) {
            throw new BadRequestException();
        }
        if (dentist.getSpecializare().getId() == null) {
            throw new BadRequestException();
        }
        if (specializareRepository.findById(dentist.getSpecializare().getId()).isEmpty()) {
            throw new BadRequestException();
        }

        return dentistRepository.save(dentist);
    }
}
