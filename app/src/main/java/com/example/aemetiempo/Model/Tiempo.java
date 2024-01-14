package com.example.aemetiempo.Model;

public class Tiempo {
    private String diaSemana;
    private String maxima;
    private String minima;

    public Tiempo(String diaSemana, String maxima, String minima) {
        this.diaSemana = diaSemana;
        this.maxima = maxima;
        this.minima = minima;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public String getMaxima() {
        return maxima;
    }

    public String getMinima() {
        return minima;
    }
}
