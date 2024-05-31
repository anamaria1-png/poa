package com.example.poa.service;

import com.example.poa.dto.*;
import com.example.poa.entity.Dentist;
import com.example.poa.entity.Pacient;
import com.example.poa.entity.Programare;
import com.example.poa.exception.BadRequestException;
import com.example.poa.exception.InternalServerErrorException;
import com.example.poa.exception.NotFoundException;
import com.example.poa.repository.AsisentaRepository;
import com.example.poa.repository.DentistRepository;
import com.example.poa.repository.PacientRepository;
import com.example.poa.repository.ProgramareRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramareService {
    private final ProgramareRepository programareRepository;
    private final DentistRepository dentistRepository;
    private final PacientRepository pacientRepository;
    private final AsisentaRepository asisentaRepository;

    public ProgramareService(ProgramareRepository programareRepository, DentistRepository dentistRepository, PacientRepository pacientRepository, AsisentaRepository asisentaRepository) {
        this.programareRepository = programareRepository;
        this.dentistRepository = dentistRepository;
        this.pacientRepository = pacientRepository;
        this.asisentaRepository = asisentaRepository;
    }

    public List<ProgramareDto> obtineToateProgramarile() {
        return convertesteDinProgramariInProgramariDto(programareRepository.findAll());
    }

    public List<ProgramareDto> obtineToateProgramarileDentistului(Integer dentistId) {
        Dentist dentist = dentistRepository.findById(dentistId).orElseThrow(NotFoundException::new);

        return convertesteDinProgramariInProgramariDto(programareRepository.findAllByDentist(dentist));
    }

    public List<ProgramareDto> obtineToateProgramarilePacientului(Integer pacientId) {
        Pacient pacient = pacientRepository.findById(pacientId).orElseThrow(NotFoundException::new);

        return convertesteDinProgramariInProgramariDto(programareRepository.findAllByPacient(pacient));
    }

    public Programare adaugaProgramare(Programare programare) {
        programare.setId(null);

        if (pacientRepository.findById(programare.getPacient().getId()).isEmpty()) {
            throw new BadRequestException();
        }
        if (dentistRepository.findById(programare.getDentist().getId()).isEmpty()) {
            throw new BadRequestException();
        }
        if (asisentaRepository.findById(programare.getAsistenta().getId()).isEmpty()) {
            throw new BadRequestException();
        }
        if (programare.getDurata() < 0) {
            throw new BadRequestException();
        }
        if (programare.getData().isBefore(LocalDateTime.now())) {
            throw new BadRequestException();
        }

        return programareRepository.save(programare);
    }

    private List<ProgramareDto> convertesteDinProgramariInProgramariDto(List<Programare> programari) {

        List<ProgramareDto> programariDto = new ArrayList<>();

        for (Programare programare : programari) {
            ProgramareDto programareDto;

            if (programare.getTipProgramare().equals(TipProgramare.CONSULTATIE)) {
                programareDto = new ConsultatieDto();
            }
            else if (programare.getTipProgramare().equals(TipProgramare.INSTALARE_APARAT_DENTAR)) {
                programareDto = new InstalareDto();
            }
            else if (programare.getTipProgramare().equals(TipProgramare.OPERATIE)) {
                programareDto = new OperatieDto();
            }
            else {
                throw new InternalServerErrorException();
            }

            programareDto.setId(programare.getId());
            programareDto.setData(programare.getData());
            programareDto.setDurata(programare.getDurata());
            programareDto.setNumePacient(programare.getPacient().getNume());
            programareDto.setNumeDentist(programare.getDentist().getNume());
            programareDto.setNumeAsistenta(programare.getAsistenta().getNume());
            programareDto.setPret(programareDto.calculeazaCostActiune());

            programariDto.add(programareDto);
        }

        return programariDto;
    }
}
