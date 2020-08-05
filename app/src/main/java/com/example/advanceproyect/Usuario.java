package com.example.advanceproyect;

public class Usuario {
    private String mail;
    private String clave;

    public Usuario(String mail, String clave) {
        this.mail = mail;
        this.clave = clave;
    }

    public Usuario() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
