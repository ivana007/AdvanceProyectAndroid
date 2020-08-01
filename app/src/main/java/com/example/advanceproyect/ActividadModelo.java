package com.example.advanceproyect;

import java.util.List;

public class ActividadModelo {
   private int fotoActividad;
   private String nombre;
   private int cupo;

    public ActividadModelo() {
    }

    public ActividadModelo(int fotoActividad, String nombre, int cupo) {
        this.fotoActividad = fotoActividad;
        this.nombre = nombre;
        this.cupo = cupo;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public int getFotoActividad() {
        return fotoActividad;
    }

    public void setFotoActividad(int fotoActividad) {
        this.fotoActividad = fotoActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
