package com.example.microservicio_factura_vet.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.microservicio_factura_vet.model.Factura;
import com.example.microservicio_factura_vet.repository.FacturaRepository;

@ExtendWith(MockitoExtension.class)
public class FacturaServiceTest {

    @InjectMocks
    private FacturaServiceImpl facturaService;

    @Mock
    private FacturaRepository facturaRepositoryMock;

    @Test
    public void createFactura_GuardarYRetornarFactura() {
        
        Factura factura = new Factura();
        factura.setCliente("Juan Pérez");
        factura.setServicio("Mantenimiento");
        factura.setTotal(15000.0);
        factura.setEstado("PAGADO");

        when(facturaRepositoryMock.save(any(Factura.class))).thenReturn(factura);

        
        Factura resultado = facturaService.createFactura(factura);

        
        assertNotNull(resultado);
        assertEquals("Juan Pérez", resultado.getCliente());
        assertEquals("Mantenimiento", resultado.getServicio());
        assertEquals(15000.0, resultado.getTotal());
        assertEquals("PAGADO", resultado.getEstado());
    }

    @Test
    public void createFactura_TotalNegativo() {
        Factura factura = new Factura();
        factura.setCliente("Juan Pérez");
        factura.setServicio("Mantenimiento");
        factura.setTotal(-15000.0);  // Total negativo
        factura.setEstado("PAGADO");

        when(facturaRepositoryMock.save(any(Factura.class))).thenReturn(factura);

        Factura resultado = facturaService.createFactura(factura);

        assertNotNull(resultado);
        assertEquals("Juan Pérez", resultado.getCliente());
        assertEquals("Mantenimiento", resultado.getServicio());
        assertEquals(-15000.0, resultado.getTotal());  // Verificamos que se guarda el total negativo
        assertEquals("PAGADO", resultado.getEstado());
    }

    @Test
    public void createFactura_TotalCero() {
        Factura factura = new Factura();
        factura.setCliente("Juan Pérez");
        factura.setServicio("Mantenimiento");
        factura.setTotal(0.0);  // Total igual a cero
        factura.setEstado("PAGADO");

        when(facturaRepositoryMock.save(any(Factura.class))).thenReturn(factura);

        Factura resultado = facturaService.createFactura(factura);

        assertNotNull(resultado);
        assertEquals("Juan Pérez", resultado.getCliente());
        assertEquals("Mantenimiento", resultado.getServicio());
        assertEquals(0.0, resultado.getTotal());  // Verificamos que el total sea 0
        assertEquals("PAGADO", resultado.getEstado());
    }
    
}