package com.example.poa.dto;

public class InstalareDto extends ProgramareDto {
    @Override
    public int calculeazaCostActiune() {
        return durata * 7;
    }
}
