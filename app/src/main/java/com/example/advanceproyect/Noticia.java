package com.example.advanceproyect;

public class Noticia {
    private int noticiaId;
    private String textoNoticia;
    private String fotoTexto;
    private int usuarioId;

    public Noticia() {
    }

    public Noticia(int noticiaId, String textoNoticia, String fotoTexto, int usuarioId) {
        this.noticiaId = noticiaId;
        this.textoNoticia = textoNoticia;
        this.fotoTexto = fotoTexto;
        this.usuarioId = usuarioId;
    }

    public int getNoticiaId() {
        return noticiaId;
    }

    public void setNoticiaId(int noticiaId) {
        this.noticiaId = noticiaId;
    }

    public String getTextoNoticia() {
        return textoNoticia;
    }

    public void setTextoNoticia(String textoNoticia) {
        this.textoNoticia = textoNoticia;
    }

    public String getFotoTexto() {
        return fotoTexto;
    }

    public void setFotoTexto(String fotoTexto) {
        this.fotoTexto = fotoTexto;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
