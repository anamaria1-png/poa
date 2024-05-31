package com.example.poa.service;

import com.example.poa.entity.Specializare;
import com.example.poa.exception.BadRequestException;
import com.example.poa.exception.ConflictingDataException;
import com.example.poa.repository.SpecializareRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SpecializareService {
    private final SpecializareRepository specializareRepository;

    public SpecializareService(SpecializareRepository specializareRepository) {
        this.specializareRepository = specializareRepository;
    }

    public List<Specializare> obtineToateSpecializarile() {
        return specializareRepository.findAll().stream().sorted(Comparator.comparing(Specializare::getNume)).toList();
    }

    public Specializare adaugaSpecializare(Specializare specializare) {
        specializare.setId(null);

        if (specializare.getNume().isBlank()) {
            throw new BadRequestException();
        }
        if (specializareRepository.findByNumeIgnoreCase(specializare.getNume()).isPresent()) {
            throw new ConflictingDataException();
        }

        return specializareRepository.save(specializare);
    }
}
