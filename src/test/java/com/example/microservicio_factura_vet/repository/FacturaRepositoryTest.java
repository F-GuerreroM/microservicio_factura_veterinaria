package com.example.microservicio_factura_vet.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.microservicio_factura_vet.model.Factura;

import jakarta.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FacturaRepositoryTest {

    @Autowired
    private FacturaRepository facturaRepository;

    @Test
    public void guardarFacturaTest() {
        Factura factura = new Factura();
        factura.setCliente("Juan Pérez");
        factura.setServicio("Limpieza");
        factura.setTotal(15000.0);
        factura.setEstado("PAGADA");

        Factura resultado = facturaRepository.save(factura);

        assertNotNull(resultado.getId());
        assertEquals("Juan Pérez", resultado.getCliente());
        assertEquals("Limpieza", resultado.getServicio());
        assertEquals(15000.0, resultado.getTotal());
        assertEquals("PAGADA", resultado.getEstado());
    }

    @Test
    public void guardarFacturaSinClienteDebeFallar() {
        Factura factura = new Factura();
        factura.setServicio("Limpieza");
        factura.setTotal(15000.0);
        factura.setEstado("PAGADA");

        assertThrows(ConstraintViolationException.class, () -> {
            facturaRepository.save(factura);
            facturaRepository.flush(); // fuerza validaciones de JPA
        });
    }
}