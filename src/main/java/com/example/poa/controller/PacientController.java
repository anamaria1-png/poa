package com.example.poa.controller;

import com.example.poa.entity.Pacient;
import com.example.poa.service.AuditService;
import com.example.poa.service.PacientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacienti")
public class PacientController {
    private final PacientService pacientService;
    private final AuditService auditService;

    public PacientController(PacientService pacientService, AuditService auditService) {
        this.pacientService = pacientService;
        this.auditService = auditService;
    }

    @GetMapping
    public List<Pacient> obtineTotiPacientii() {
        auditService.salveazaActiune("Obtine toti pacientii");

        return pacientService.obtineTotiPacientii();
    }

    @PostMapping
    public Pacient adaugaPacient(@RequestBody Pacient pacient) {
        auditService.salveazaActiune("Adauga pacient");

        return pacientService.adaugaPacient(pacient);
    }
}
