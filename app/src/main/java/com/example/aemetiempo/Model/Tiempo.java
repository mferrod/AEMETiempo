package com.example.aemetiempo.Model;

import com.example.aemetiempo.R;

public class Tiempo {
    private final String diaSemana;
    private final String maxima;
    private final String minima;
    private final int imageIntDraw;

    public Tiempo(String diaSemana, String maxima, String minima, String temporal) {
        this.diaSemana = diaSemana;
        this.maxima = maxima;
        this.minima = minima;
        this.imageIntDraw = this.setImageFromString(temporal);
    }

    public String getDiaSemana() {
        return this.diaSemana;
    }

    public String getMaxima() {
        return this.maxima;
    }

    public String getMinima() {
        return this.minima;
    }
    public int getImage() {return this.imageIntDraw;}
    private int setImageFromString(String nombreTemporal) {
        int drawable = 0;
        switch (nombreTemporal) {
            case "Soleado":
                drawable = R.drawable.soleado;
                break;
            case "Nublado":
                drawable = R.drawable.nubes;
                break;
            case "Despejado":
                drawable = R.drawable.soleado;
                break;
            case "Poco nuboso":
                drawable = R.drawable.poco_nuboso;
                break;
            case "Nubes altas":
                drawable = R.drawable.nubes;
                break;
            case "Muy nuboso":
                drawable = R.drawable.nubes;
                break;
            case "Lluvia":
                drawable = R.drawable.lluvia;
                break;
            case "Nieve":
                drawable = R.drawable.nieve;
                break;
            case "Granizo":
                drawable = R.drawable.granizo;
                break;
            case "default":
                break;
        }
        return drawable;
    }
}
