package com.example.advanceproyect;

import java.sql.Time;
import java.util.Date;

public class Horario {
    private int horarioId;
    private String fecha;
    private String hora;
    private int ClienteId;
    private int ClaseId;

    public Horario() {
    }

    public Horario(int horarioId, String fecha, String hora, int clienteId, int claseId) {
        this.horarioId = horarioId;
        this.fecha = fecha;
        this.hora = hora;
        ClienteId = clienteId;
        ClaseId = claseId;
    }

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getClienteId() {
        return ClienteId;
    }

    public void setClienteId(int clienteId) {
        ClienteId = clienteId;
    }

    public int getClaseId() {
        return ClaseId;
    }

    public void setClaseId(int claseId) {
        ClaseId = claseId;
    }
}
