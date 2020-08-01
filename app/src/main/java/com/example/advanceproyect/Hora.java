package com.example.advanceproyect;

public class Hora {
    private int time;
    private int minuto;

    public Hora(int time, int minuto) {
        this.time = time;
        this.minuto = minuto;
    }

    public Hora() {
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
}
