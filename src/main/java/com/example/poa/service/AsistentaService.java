package com.example.poa.service;

import com.example.poa.entity.Asistenta;
import com.example.poa.exception.BadRequestException;
import com.example.poa.repository.AsisentaRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AsistentaService {
    private final AsisentaRepository asisentaRepository;

    public AsistentaService(AsisentaRepository asisentaRepository) {
        this.asisentaRepository = asisentaRepository;
    }

    public List<Asistenta> obtineToateAsistentele() {
        return asisentaRepository.findAll().stream().sorted(Comparator.comparing(Asistenta::getNume)).toList();
    }

    public Asistenta adaugaAsistenta(Asistenta asistenta) {
        asistenta.setId(null);

        if (asistenta.getNume().isBlank()) {
            throw new BadRequestException();
        }

        return asisentaRepository.save(asistenta);
    }
}
