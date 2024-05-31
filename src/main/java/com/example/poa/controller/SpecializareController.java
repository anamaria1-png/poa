package com.example.poa.controller;

import com.example.poa.entity.Specializare;
import com.example.poa.service.AuditService;
import com.example.poa.service.SpecializareService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specializari")
public class SpecializareController {
    private final SpecializareService specializareService;
    private final AuditService auditService;

    public SpecializareController(SpecializareService specializareService, AuditService auditService) {
        this.specializareService = specializareService;
        this.auditService = auditService;
    }

    @GetMapping
    public List<Specializare> obtineToateSpeializarile() {
        auditService.salveazaActiune("Obtine toate specializarile");

        return specializareService.obtineToateSpecializarile();
    }

    @PostMapping
    public Specializare adaugaSpecializare(@RequestBody Specializare specializare) {
        auditService.salveazaActiune("Adauga specializare");

        return specializareService.adaugaSpecializare(specializare);
    }
}
