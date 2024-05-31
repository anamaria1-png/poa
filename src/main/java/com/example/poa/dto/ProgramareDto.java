package com.example.poa.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class ProgramareDto implements ActiunePlatibila {
    protected Integer id;
    protected String numeDentist;
    protected String numePacient;
    protected String numeAsistenta;
    protected int durata;
    protected LocalDateTime data;
    protected int pret;
}
