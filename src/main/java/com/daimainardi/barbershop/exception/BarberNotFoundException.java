package com.daimainardi.barbershop.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BarberNotFoundException extends RuntimeException{
    private final HttpStatus status;
    public BarberNotFoundException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }
}
