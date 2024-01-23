package com.example.aemetiempo.Controller;

import com.example.aemetiempo.Model.Localidad;

import java.util.ArrayList;

public class CSVToLocalidad {
    private final String[] localidadesencsv;

    public CSVToLocalidad(String[] localidadesencsv) {
        this.localidadesencsv = localidadesencsv;
    }

    public ArrayList<Localidad> obtainLocalidadesFromCSV() {
        ArrayList<Localidad> localidades = new ArrayList<>();
        for (String csvEnString : localidadesencsv) {
            String[] csvParseado;
            csvParseado = csvEnString.split(";");
            localidades.add(new Localidad(csvParseado[0],csvParseado[1],csvParseado[2],csvParseado[3],csvParseado[4]));
        }
        return localidades;
    }
}
