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

    @PostMapping
    public Factura creaStudent(@RequestBody Factura factura) {
        return facturaService.createFactura(factura);
    }
    
    @PutMapping("/{id}")
    public Factura updateStudent(@PathVariable Long id, @RequestBody Factura factura) {
        return facturaService.updateFactura(id, factura);
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id){
        facturaService.deleteFactura(id);
    }
}






// @RestController
// @RequestMapping("/api/facturas")
// public class facturaController {

//     private List<Factura> facturas = new ArrayList<>();

//     public facturaController() {
//         // Inicializar facturas con servicios veterinarios y costos
//         facturas.add(new Factura(1, "Juan Pérez", "Consulta general, Vacuna antirrábica", 50000));
//         facturas.add(new Factura(2, "María González", "Cirugía menor, Desparasitación", 12000));
//         facturas.add(new Factura(3, "Carlos López", "Radiografía, Tratamiento dental", 200000));
//         facturas.add(new Factura(4, "Ana Fernández", "Consulta de emergencia", 15000));
//         facturas.add(new Factura(5, "Luis Ramírez", "Baño y peluquería, Corte de uñas", 10000));
//     }

//     // GET para listar todas las facturas
//     @GetMapping
//     public List<Factura> obtenerFacturas() {
//         return facturas;
//     }

//     // GET para obtener una factura por ID
//     @GetMapping("/{id}")
//     public Factura obtenerFacturaPorId(@PathVariable int id) {
//         return facturas.stream()
//                 .filter(factura -> factura.getId() == id)
//                 .findFirst()
//                 .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
//     }

//      // GET para obtener el total de todas las facturas
//      @GetMapping("/total")
//      public int calcularTotalFacturas() {
//          int total = 0;
//          for (Factura factura : facturas) {
//              total += factura.getTotal();
//          }
//          return total;
//      }
// }
