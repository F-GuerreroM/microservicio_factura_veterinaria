package com.example.microservicio_factura_vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.microservicio_factura_vet.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    @Query("SELECT COALESCE(SUM(f.total), 0.0) FROM Factura f")
Double sumarTotalFacturas();

}
