package com.example.advanceproyect;

public class HorarioAux {
    private String dia;
    private String hora;
    private int actividadId;

    public HorarioAux(String dia, String hora, int actividadId) {
        this.dia = dia;
        this.hora = hora;
        this.actividadId = actividadId;
    }

    public HorarioAux() {
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

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }
}
