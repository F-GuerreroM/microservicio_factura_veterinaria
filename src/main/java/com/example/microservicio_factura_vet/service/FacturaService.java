package com.example.microservicio_factura_vet.service;

import com.example.microservicio_factura_vet.model.Factura;
import java.util.List;
import java.util.Optional;

public interface FacturaService {
    List<Factura> getAllFacturas();
    Optional<Factura> getFacturaById(Long id);
    Factura createFactura(Factura factura);
    Factura updateFactura(Long id,Factura factura);
    void deleteFactura(Long id);
    Double calcularTotalFacturas();    
}
