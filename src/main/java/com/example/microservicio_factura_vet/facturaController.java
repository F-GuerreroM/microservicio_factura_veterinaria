package com.example.microservicio_factura_vet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class facturaController {

    private List<factura> facturas = new ArrayList<>();

    public facturaController() {
        // Inicializar facturas con servicios veterinarios y costos
        facturas.add(new factura(1, "Juan Pérez", "Consulta general, Vacuna antirrábica", 50000));
        facturas.add(new factura(2, "María González", "Cirugía menor, Desparasitación", 12000));
        facturas.add(new factura(3, "Carlos López", "Radiografía, Tratamiento dental", 200000));
        facturas.add(new factura(4, "Ana Fernández", "Consulta de emergencia", 15000));
        facturas.add(new factura(5, "Luis Ramírez", "Baño y peluquería, Corte de uñas", 10000));
    }

    // GET para listar todas las facturas
    @GetMapping
    public List<factura> obtenerFacturas() {
        return facturas;
    }

    // GET para obtener una factura por ID
    @GetMapping("/{id}")
    public factura obtenerFacturaPorId(@PathVariable int id) {
        return facturas.stream()
                .filter(factura -> factura.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

     // GET para obtener el total de todas las facturas
     @GetMapping("/total")
     public int calcularTotalFacturas() {
         int total = 0;
         for (factura factura : facturas) {
             total += factura.getTotal();
         }
         return total;
     }
}
