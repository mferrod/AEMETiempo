package com.example.aemetiempo.Model;

public class Localidad {
    private final String codautonomia; //Código comunidad autónoma
    private final String cprovincia; //Código de provincia
    private final String codmunicipio; //Código de municipio
    private final String dc; //??? -- Por descubrir
    private final String nombreLocalidad; //Nombre de la localidad (como el nombre de variable indica)

    public Localidad(String codautonomia, String cprovincia, String codmunicipio,
                     String dc, String nombreLocalidad) {
        this.codautonomia = codautonomia;
        this.cprovincia = cprovincia;
        this.codmunicipio = codmunicipio;
        this.dc = dc;
        this.nombreLocalidad = nombreLocalidad;
    }

    public String getCodautonomia() {
        return codautonomia;
    }

    public String getCprovincia() {
        return cprovincia;
    }

    public String getCodmunicipio() {
        return codmunicipio;
    }

    public String getDc() {
        return dc;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }
}
