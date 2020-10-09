package com.example.advanceproyect;

public class Actividad {
    private int actividadId;
    private String nombre ;
    private int cupo;
    private String estado;
    private String imagen;

    public Actividad() {
    }

    public Actividad(int actividadId, String nombre, int cupo, String estado, String imagen) {
        this.actividadId = actividadId;
        this.nombre = nombre;
        this.cupo = cupo;
        this.estado = estado;
        this.imagen = imagen;
    }

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
