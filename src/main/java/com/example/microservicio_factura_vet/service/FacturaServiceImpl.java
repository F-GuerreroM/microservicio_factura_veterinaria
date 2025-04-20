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
    public Factura updateFactura(Long id, Factura factura){
        if(facturaRepository.existsById(id)){
            factura.setId(id);
            return facturaRepository.save(factura);
        }   else {
                return null;
        }
    }

    @Override
    public void deleteFactura(Long id){
        facturaRepository.deleteById(id);
    }
}