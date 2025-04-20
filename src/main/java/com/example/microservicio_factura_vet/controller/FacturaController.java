package com.example.microservicio_factura_vet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio_factura_vet.model.Factura;
import com.example.microservicio_factura_vet.service.FacturaService;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> getAllFacturas(){
        return facturaService.getAllFacturas();
    }
        
    @GetMapping("/{id}")
    public Optional<Factura> getFacturaById(@PathVariable Long id) {
        return facturaService.getFacturaById(id);
    }

    @GetMapping("/total")
    public Double obtenerTotalFacturas() {
        return facturaService.calcularTotalFacturas();
    }

    @PostMapping
    public Factura creaFactura(@RequestBody Factura factura) {
        return facturaService.createFactura(factura);
    }
    
    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura factura) {
        return facturaService.updateFactura(id, factura);
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id){
        facturaService.deleteFactura(id);
    }
}