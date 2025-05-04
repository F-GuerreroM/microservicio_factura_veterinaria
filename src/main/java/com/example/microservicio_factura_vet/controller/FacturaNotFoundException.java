package com.example.microservicio_factura_vet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Esto le indica a Spring que devuelva un HTTP 404
public class FacturaNotFoundException extends RuntimeException {

    public FacturaNotFoundException(String message) {
        super(message);
    }
}