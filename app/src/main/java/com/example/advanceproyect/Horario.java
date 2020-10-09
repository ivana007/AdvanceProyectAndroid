package com.example.advanceproyect;

import java.sql.Time;
import java.util.Date;

public class Horario {
    private int horarioId;
    private String dia;
    private String hora;
    private String estado;
    private int claseId;
    private int actividadId;
   private Actividad actividad;


    public Horario() {
    }

    public Horario(int horarioId, String dia, String hora, String estado, int claseId, int actividadId, Actividad actividad) {
        this.horarioId = horarioId;
        this.dia = dia;
        this.hora = hora;
        this.estado = estado;
        this.claseId = claseId;
        this.actividadId = actividadId;
        this.actividad = actividad;
    }

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getClaseId() {
        return claseId;
    }

    public void setClaseId(int claseId) {
        this.claseId = claseId;
    }

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}
