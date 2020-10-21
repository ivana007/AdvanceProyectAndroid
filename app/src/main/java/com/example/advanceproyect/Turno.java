package com.example.advanceproyect;

import com.example.advanceproyect.ui.perfil.Usuario;

import java.util.Date;

public class Turno {
    private int turnoId ;
    private String estado ;
    private Date fecha ;
    private String asistencia ;
    private int usuarioId ;
    private int horarioId ;
    private Horario horario;
    private Usuario usuario ;

    public Turno() {
    }

    public Turno(int turnoId, String estado, Date fecha, String asistencia, int usuarioId, int horarioId, Horario horario, Usuario usuario) {
        this.turnoId = turnoId;
        this.estado = estado;
        this.fecha = fecha;
        this.asistencia = asistencia;
        this.usuarioId = usuarioId;
        this.horarioId = horarioId;
        this.horario = horario;
        this.usuario = usuario;
    }

    public int getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(int turnoId) {
        this.turnoId = turnoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
