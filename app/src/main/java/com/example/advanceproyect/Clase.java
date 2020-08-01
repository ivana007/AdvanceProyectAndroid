package com.example.advanceproyect;

public class Clase {
    private int claseId;
    private String nombre;
    private double precio;
    private int cupo;

    public Clase() {
    }

    public Clase(int claseId, String nombre, double precio, int cupo) {
        this.claseId = claseId;
        this.nombre = nombre;
        this.precio = precio;
        this.cupo = cupo;
    }

    public int getClaseId() {
        return claseId;
    }

    public void setClaseId(int claseId) {
        this.claseId = claseId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
}
