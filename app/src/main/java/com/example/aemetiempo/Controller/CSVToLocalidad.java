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
            int i = 0;
            while (i < localidadesencsv.length) {
                String str = localidadesencsv[i];
                String[] klm;
                klm = str.split(";");
                localidades.add(new Localidad(klm[0], klm[1], klm[2], klm[3], klm[4]));
                i++;
            }
        return localidades;
    }
}
