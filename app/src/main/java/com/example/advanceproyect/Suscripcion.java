package com.example.advanceproyect;

import java.util.Date;

public class Suscripcion {
    private int suscripcionId;
    private Date fechaAlta;
    private Date fechaBaja;
    private int cantidadClases;
    private int usuarioId;
    private int precioId;
    private int actividadId;
    private Usuario usuario;
    private Actividad actividad;
    private Precio precio;

    public Suscripcion() {
    }

    public Suscripcion(int suscripcionId, Date fechaAlta, Date fechaBaja, int cantidadClases,
                       int usuarioId, int precioId, int actividadId, Usuario usuario,
                       Actividad actividad, Precio precio) {
        this.suscripcionId = suscripcionId;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.cantidadClases = cantidadClases;
        this.usuarioId = usuarioId;
        this.precioId = precioId;
        this.actividadId = actividadId;
        this.usuario = usuario;
        this.actividad = actividad;
        this.precio = precio;
    }

    public int getSuscripcionId() {
        return suscripcionId;
    }

    public void setSuscripcionId(int suscripcionId) {
        this.suscripcionId = suscripcionId;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public int getCantidadClases() {
        return cantidadClases;
    }

    public void setCantidadClases(int cantidadClases) {
        this.cantidadClases = cantidadClases;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPrecioId() {
        return precioId;
    }

    public void setPrecioId(int precioId) {
        this.precioId = precioId;
    }

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }
}
