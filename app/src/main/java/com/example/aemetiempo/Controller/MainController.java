package com.example.aemetiempo.Controller;

import com.example.aemetiempo.Model.CSVToLocalidad;
import com.example.aemetiempo.Model.Localidad;
import com.example.aemetiempo.Model.Peticion;
import com.example.aemetiempo.Model.Respuesta;
import com.example.aemetiempo.Model.Tiempo;
import com.example.aemetiempo.View.MainActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainController {
    private final String API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJpYW5vZmRlenJvZGVyb0BnbWFpbC5jb20iLCJqdGkiOiI5MGE5Mzk4MS04MWJjLTRlZTAtOTgwNy03Zjc5OTQ0OTI3NTQiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTcwMDU5MzY3NiwidXNlcklkIjoiOTBhOTM5ODEtODFiYy00ZWUwLTk4MDctN2Y3OTk0NDkyNzU0Iiwicm9sZSI6IiJ9.8rgI1jhZhZbTjmUa-TOJ0xYv73P_V88dVa6CjcIt8Cc";
    private static MainController mySingleController;
    private static MainActivity mainActivity;
    private final ArrayList<Localidad> localidadesSeleccionadas = new ArrayList<>();

    private List<Tiempo> tiempoData;
    private MainController() {
        tiempoData = new LinkedList<>();
    }

    public static MainController getSingleton() {
        if (MainController.mySingleController == null)
            mySingleController = new MainController();
        return mySingleController;
    }
    public void getLocalidades(String textoParecido, String[] localidadescsv) {
        CSVToLocalidad n = new CSVToLocalidad(localidadescsv);
        ArrayList<Localidad> x = n.obtainLocalidadesFromCSV();
        for (int i = 0; i < x.size(); i++) {
            String s = x.get(i).getNombreLocalidad().substring(0, textoParecido.length());
            if (s.equals(textoParecido))
                localidadesSeleccionadas.add(x.get(i));
        }
    }
    public void getDataFromAEMET(String code) {
        Peticion p = new Peticion();
        p.requestDataURL(code);
    }
    public void sendURLFromHTML(String html) {
        Peticion p = new Peticion();
        String newUrl = html.substring(html.indexOf("https://"), html.indexOf("metadatos"));
        newUrl = newUrl.substring(0, newUrl.indexOf("\""));
        p.requestDataURL2Json(newUrl);
    }
    public void setDataFromAEMET(String aemetres) {
        Respuesta respuesta = new Respuesta(aemetres);
        tiempoData = respuesta.getData();

        //MainController.mainActivity.accessToData();
    }
    public void setErrorFromAEMET(String aemetres) {
        MainController.mainActivity.setError(aemetres); //Mando el error al Activity
    }
    public List<Tiempo> dameDatosTiempo() {
        return this.tiempoData;
    }

    public ArrayList<Localidad> getLocalidadesSeleccionadas() {
        if (localidadesSeleccionadas == null)
            return new ArrayList<>();
        return localidadesSeleccionadas;
    }

    public static void setActivity(MainActivity myActi) {
        mainActivity = myActi;
    }


}
