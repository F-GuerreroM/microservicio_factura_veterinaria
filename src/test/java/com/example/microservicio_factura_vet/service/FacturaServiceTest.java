package com.example.microservicio_factura_vet.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
}