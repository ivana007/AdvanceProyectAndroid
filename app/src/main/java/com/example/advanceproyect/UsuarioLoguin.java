package com.example.advanceproyect;

public class UsuarioLoguin {
    private String mail;
    private String clave;

    public UsuarioLoguin(String mail, String clave) {
        this.mail = mail;
        this.clave = clave;
    }

    public UsuarioLoguin() {
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
