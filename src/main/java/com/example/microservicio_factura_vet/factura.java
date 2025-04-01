package com.example.microservicio_factura_vet;

public class factura {
    private int id;
    private String cliente;
    private String servicios;
    private double total;

    public factura(int id, String cliente, String servicios, int total) {
        this.id = id;
        this.cliente = cliente;
        this.servicios = servicios;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
