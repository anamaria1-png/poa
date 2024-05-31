package com.example.poa.entity;

import com.example.poa.dto.TipProgramare;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Programare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime data;
    private TipProgramare tipProgramare;
    private int durata;
    @ManyToOne
    @JoinColumn(name="asistenta_id", nullable=false)
    private Asistenta asistenta;
    @ManyToOne
    @JoinColumn(name="dentist_id", nullable=false)
    private Dentist dentist;
    @ManyToOne
    @JoinColumn(name="pacient_id", nullable=false)
    private Pacient pacient;
}
