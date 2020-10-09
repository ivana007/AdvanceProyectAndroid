package com.example.advanceproyect;

public class Precio {
    private int precioId;
    private Double costo;
    private String estado;

    public Precio() {
    }

    public Precio(int precioId, Double costo, String estado) {
        this.precioId = precioId;
        this.costo = costo;
        this.estado = estado;
    }

    public int getPrecioId() {
        return precioId;
    }

    public void setPrecioId(int precioId) {
        this.precioId = precioId;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
