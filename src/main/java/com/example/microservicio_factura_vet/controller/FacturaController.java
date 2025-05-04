package com.example.microservicio_factura_vet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio_factura_vet.model.Factura;
import com.example.microservicio_factura_vet.service.FacturaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public CollectionModel<EntityModel<Factura>> getAllFacturas() {
        List<EntityModel<Factura>> facturas = facturaService.getAllFacturas().stream()
                .map(factura -> EntityModel.of(factura,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getFacturaById(factura.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllFacturas()).withRel("all-facturas")
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(facturas,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllFacturas()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Factura> getFacturaById(@PathVariable Long id) {
        Optional<Factura> factura = facturaService.getFacturaById(id);

        if (factura.isPresent()) {
            return EntityModel.of(factura.get(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getFacturaById(id)).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllFacturas()).withRel("all-facturas"));
        } else {
            throw new RuntimeException("Factura no encontrada con id: " + id);
        }
    }

    @PostMapping
    public EntityModel<Factura> createFactura(@RequestBody Factura factura) {
        Factura createdFactura = facturaService.createFactura(factura);
        return EntityModel.of(createdFactura,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getFacturaById(createdFactura.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllFacturas()).withRel("all-facturas"));
    }

    @PutMapping("/{id}")
    public EntityModel<Factura> updateFactura(@PathVariable Long id, @RequestBody Factura factura) {
        Factura updatedFactura = facturaService.updateFactura(id, factura);
        return EntityModel.of(updatedFactura,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getFacturaById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllFacturas()).withRel("all-facturas"));
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id) {
        facturaService.deleteFactura(id);
    }

    @GetMapping("/total")
    public Double obtenerTotalFacturas() {
        return facturaService.calcularTotalFacturas();
    }
}