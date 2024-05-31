package com.example.poa.controller;

import com.example.poa.entity.Asistenta;
import com.example.poa.service.AsistentaService;
import com.example.poa.service.AuditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asistente")
public class AsistentaController {
    private final AsistentaService asistentaService;
    private final AuditService auditService;

    public AsistentaController(AsistentaService asistentaService, AuditService auditService) {
        this.asistentaService = asistentaService;
        this.auditService = auditService;
    }

    @GetMapping
    public List<Asistenta> obtineToateAsistentele() {
        auditService.salveazaActiune("Obtine toate asistentele");

        return asistentaService.obtineToateAsistentele();
    }

    @PostMapping
    public Asistenta adaugaAsistenta(@RequestBody Asistenta asistenta) {
        auditService.salveazaActiune("Adauga asistenta");

        return asistentaService.adaugaAsistenta(asistenta);
    }
}
