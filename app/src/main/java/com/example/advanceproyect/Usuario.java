package com.example.advanceproyect;

public class Usuario {
    private String email;
    private String clave;

    public Usuario(String mail, String clave) {
        this.email = mail;
        this.clave = clave;
    }

    public Usuario() {
    }

    public String getMail() {
        return email;
    }

    public void setMail(String mail) {
        this.email = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
