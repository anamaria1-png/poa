package com.example.poa.service;

import com.example.poa.dto.TipProgramare;
import com.example.poa.entity.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AplicatieService {
    private final SpecializareService specializareService;
    private final AsistentaService asistentaService;
    private final PacientService pacientService;
    private final DentistService dentistService;
    private final ProgramareService programareService;

    public AplicatieService(SpecializareService specializareService, AsistentaService asistentaService, PacientService pacientService, DentistService dentistService, ProgramareService programareService) {
        this.specializareService = specializareService;
        this.asistentaService = asistentaService;
        this.pacientService = pacientService;
        this.dentistService = dentistService;
        this.programareService = programareService;
    }

    public void adaugaDateInitiale() {
        adaugaSpecializariInitiale();
        adaugaAsistenteInitiale();
        adaugaPacientiInitiali();
        adaugaDentistiInitiali();
        adaugaProgramariInitiale();
    }

    private void adaugaSpecializariInitiale() {
        Specializare specializare = new Specializare();
        specializare.setNume("Chirurgie orala");
        Specializare specializare2 = new Specializare();
        specializare2.setNume("Estetica dentara");

        specializareService.adaugaSpecializare(specializare);
        specializareService.adaugaSpecializare(specializare2);
    }

    private void adaugaAsistenteInitiale() {
        Asistenta asistenta = new Asistenta();
        asistenta.setNume("Andreea Panait");
        Asistenta asistenta2 = new Asistenta();
        asistenta2.setNume("Maria Iorgu");

        asistentaService.adaugaAsistenta(asistenta);
        asistentaService.adaugaAsistenta(asistenta2);
    }

    private void adaugaPacientiInitiali() {
        Pacient pacient = new Pacient();
        pacient.setNume("Andrei Parvu");
        pacient.setCnp("1234567891234");
        Pacient pacient2 = new Pacient();
        pacient2.setNume("Andrei Pascu");
        pacient2.setCnp("1234567891235");

        pacientService.adaugaPacient(pacient);
        pacientService.adaugaPacient(pacient2);
    }

    private void adaugaDentistiInitiali() {
        Dentist dentist = new Dentist();
        dentist.setNume("Ion Pascu");
        dentist.setSpecializare(specializareService.obtineToateSpecializarile().get(0));
        Dentist dentist2 = new Dentist();
        dentist2.setNume("Ion Gheorghe");
        dentist2.setSpecializare(specializareService.obtineToateSpecializarile().get(1));

        dentistService.adaugaDentist(dentist);
        dentistService.adaugaDentist(dentist2);
    }
    private void adaugaProgramariInitiale() {
        Programare programare = new Programare();
        programare.setAsistenta(asistentaService.obtineToateAsistentele().get(0));
        programare.setData(LocalDateTime.now().plusHours(3));
        programare.setTipProgramare(TipProgramare.CONSULTATIE);
        programare.setDurata(30);
        programare.setDentist(dentistService.obtineTotiDentistii().get(0));
        programare.setPacient(pacientService.obtineTotiPacientii().get(0));

        Programare programare2 = new Programare();
        programare2.setAsistenta(asistentaService.obtineToateAsistentele().get(1));
        programare2.setData(LocalDateTime.now().plusHours(4));
        programare2.setTipProgramare(TipProgramare.INSTALARE_APARAT_DENTAR);
        programare2.setDurata(30);
        programare2.setDentist(dentistService.obtineTotiDentistii().get(1));
        programare2.setPacient(pacientService.obtineTotiPacientii().get(1));

        Programare programare3 = new Programare();
        programare3.setAsistenta(asistentaService.obtineToateAsistentele().get(1));
        programare3.setData(LocalDateTime.now().plusHours(24));
        programare3.setTipProgramare(TipProgramare.OPERATIE);
        programare3.setDurata(60);
        programare3.setDentist(dentistService.obtineTotiDentistii().get(1));
        programare3.setPacient(pacientService.obtineTotiPacientii().get(0));

        programareService.adaugaProgramare(programare);
        programareService.adaugaProgramare(programare2);
        programareService.adaugaProgramare(programare3);
    }
}
