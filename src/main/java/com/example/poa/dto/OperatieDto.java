package com.example.poa.dto;

public class OperatieDto extends ProgramareDto {
    @Override
    public int calculeazaCostActiune() {
        return durata * 10;
    }
}
