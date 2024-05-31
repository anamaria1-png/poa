package com.example.poa.controller;

import com.example.poa.entity.Audit;
import com.example.poa.service.AuditService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actiuni")
public class AuditController {
    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping
    public List<Audit> obtineToateAsistentele() {
        auditService.salveazaActiune("Obtine toate actiunile");

        return auditService.auditeazaActiuni();
    }
}
