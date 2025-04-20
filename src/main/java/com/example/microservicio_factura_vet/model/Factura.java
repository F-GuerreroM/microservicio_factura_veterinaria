package com.example.microservicio_factura_vet.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(name= "cliente")
        private String cliente;        
        @Column(name= "servicio")
        private String servicio;
        @Column(name= "total")
        private double total;
       //Getters and setters    
    public Long getId() {
        return id;
    }
    public String getCliente() {
        return cliente;
    }
    public String getServicio() {
        return servicio;
    }    
    public double getTotal() {
        return total;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public void setServicios(String servicio) {
        this.servicio = servicio;
    }
    public void setTotal(double total) {
        this.total = total;
    }   
}
