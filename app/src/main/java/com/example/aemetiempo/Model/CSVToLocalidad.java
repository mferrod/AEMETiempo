package com.example.aemetiempo.Model;

import com.example.aemetiempo.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
