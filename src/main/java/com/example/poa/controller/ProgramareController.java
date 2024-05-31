package com.example.poa.controller;

import com.example.poa.dto.ProgramareDto;
import com.example.poa.entity.Programare;
import com.example.poa.service.AuditService;
import com.example.poa.service.ProgramareService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programari")
public class ProgramareController {
    private final ProgramareService programareService;
    private final AuditService auditService;

    public ProgramareController(ProgramareService programareService, AuditService auditService) {
        this.programareService = programareService;
        this.auditService = auditService;
    }

    @GetMapping
    public List<ProgramareDto> obtineToateProgramarile() {
        auditService.salveazaActiune("Obtine toate programarile");

        return programareService.obtineToateProgramarile();
    }

    @GetMapping("/dentisti/{dentistId}")
    public List<ProgramareDto> obtineToateProgramarileDoctorului(@PathVariable int dentistId) {
        auditService.salveazaActiune("Obtine toate programarile dentistului");

        return programareService.obtineToateProgramarileDentistului(dentistId);
    }

    @GetMapping("/pacienti/{pacientId}")
    public List<ProgramareDto> obtineToateProgramarilePacientului(@PathVariable int pacientId) {
        auditService.salveazaActiune("Obtine toate programarile pacientului");

        return programareService.obtineToateProgramarilePacientului(pacientId);
    }

    @PostMapping
    public Programare adaugaProgramare(@RequestBody Programare programare) {
        auditService.salveazaActiune("Adauga programare");

        return programareService.adaugaProgramare(programare);
    }
}
