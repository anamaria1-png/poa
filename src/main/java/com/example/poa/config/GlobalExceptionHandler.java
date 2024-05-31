package com.example.poa.config;

import com.example.poa.exception.BadRequestException;
import com.example.poa.exception.ConflictingDataException;
import com.example.poa.exception.InternalServerErrorException;
import com.example.poa.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ConflictingDataException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public String handleConflictingDataException() {
        return "Datele introduse sunt in conflict cu ce e salvat in baza de date";
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleNotFoundException() {
        return "Informatia cautata nu exista";
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleBadRequestException() {
        return "Informatia introdusa contine erori";
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleInternalServerErrorException() {
        return "A aparut o eroare neasteptata";
    }
}
