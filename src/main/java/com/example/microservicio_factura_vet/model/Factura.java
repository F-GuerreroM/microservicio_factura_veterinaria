package com.example.microservicio_factura_vet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "factura")
public class Factura {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        
        @Column(name = "id")        
        private Long id;
        @NotNull
        @Size(max=40)   
        @Column(name= "cliente")
        private String cliente; 
        @NotNull
             
        @Column(name= "servicio")
        private String servicio;
        @NotNull
        @Min(1000)
        @Max(999999)
        private Double total;
        @NotNull        
        @Column(name= "estado")
        
        private String estado;
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
    public Double getTotal() {
        return total;
    }
    public String getEstado() {
        return estado;
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
    public void setTotal(Double total) {
        this.total = total;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }   
}
