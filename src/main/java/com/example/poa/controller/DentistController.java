package com.example.poa.controller;

import com.example.poa.entity.Dentist;
import com.example.poa.service.AuditService;
import com.example.poa.service.DentistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentisti")
public class DentistController {
    private final DentistService dentistService;
    private final AuditService auditService;

    public DentistController(DentistService dentistService, AuditService auditService) {
        this.dentistService = dentistService;
        this.auditService = auditService;
    }

    @GetMapping
    public List<Dentist> obtineTotiDentistii() {
        auditService.salveazaActiune("Obtine toti dentistii");

        return dentistService.obtineTotiDentistii();
    }

    @PostMapping
    public Dentist adaugaDentist(@RequestBody Dentist dentist) {
        auditService.salveazaActiune("Adauga dentist");

        return dentistService.adaugaDentist(dentist);
    }
}
