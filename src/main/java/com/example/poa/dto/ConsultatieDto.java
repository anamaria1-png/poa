package com.example.poa.dto;

public class ConsultatieDto extends ProgramareDto {
    @Override
    public int calculeazaCostActiune() {
        return durata * 5;
    }
}
