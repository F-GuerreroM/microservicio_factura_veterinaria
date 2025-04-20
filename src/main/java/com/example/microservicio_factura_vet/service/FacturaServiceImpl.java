package com.example.microservicio_factura_vet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_factura_vet.model.Factura;
import com.example.microservicio_factura_vet.repository.FacturaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService{
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> getFacturaById(Long id) {
        return facturaRepository.findById(id);
    }
    
    @Override
    public Factura createFactura(Factura factura){
        return facturaRepository.save(factura);
    }

    @Override
public Factura updateFactura(Long id, Factura factura) {
    Optional<Factura> facturaExistenteOpt = facturaRepository.findById(id);
    if (facturaExistenteOpt.isPresent()) {
        Factura facturaExistente = facturaExistenteOpt.get();

        // Solo actualiza si viene un valor nuevo (evita pisar con null)
        if (factura.getEstado() != null)
            facturaExistente.setEstado(factura.getEstado());

        if (factura.getTotal() != null)
            facturaExistente.setTotal(factura.getTotal());
        
        return facturaRepository.save(facturaExistente);
    } else {
        return null;
    }
}

    @Override
    public void deleteFactura(Long id){
        facturaRepository.deleteById(id);
    }

    @Override
    public Double calcularTotalFacturas() {
        return facturaRepository.sumarTotalFacturas();
    }
}