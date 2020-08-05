package com.example.advanceproyect;

import java.util.List;

public class ActividadModelo {
    private int actividadId;
   private int fotoActividad;
   private String nombre;
   private int cupo;

    public ActividadModelo() {
    }

    public ActividadModelo(int actividadId,int fotoActividad, String nombre, int cupo) {
        this.actividadId=actividadId;
        this.fotoActividad = fotoActividad;
        this.nombre = nombre;
        this.cupo = cupo;
    }

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
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
