package com.example.aemetiempo.Model;

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
    private BufferedReader bufferedReader;

    public CSVToLocalidad(String fileLocation) {
        try {
            bufferedReader = new BufferedReader(new FileReader("res\\assets\\20comun.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Localidad> obtainLocalidadesFromCSV() {
        ArrayList<Localidad> localidades = new ArrayList<>();
            try {
                String str = null;
                String[] 
                while ((str = bufferedReader.readLine()) != null) {
                    str.split(";");
                    localidades.add(new Localidad());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return localidades;
        }
    }
}
