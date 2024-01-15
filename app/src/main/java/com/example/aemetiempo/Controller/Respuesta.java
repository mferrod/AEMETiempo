package com.example.aemetiempo.Controller;

import com.example.aemetiempo.Controller.MainController;
import com.example.aemetiempo.Model.Fecha;
import com.example.aemetiempo.Model.Tiempo;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import java.util.LinkedList;
import java.util.List;

public class Respuesta {
    protected String datosJson;
    public Respuesta(String json) {
        datosJson = json;
    }

    public LinkedList<Tiempo> getData() {
        LinkedList<Tiempo> data = new LinkedList<>();

        try {
            JsonElement jsonparseao = JsonParser.parseString(this.datosJson);
            JsonArray jsonArray = jsonparseao.getAsJsonArray();
            JsonObject miarrayporfin = jsonArray.get(0).getAsJsonObject();
            JsonElement arrayelement = miarrayporfin.get("prediccion");
            JsonObject dias = arrayelement.getAsJsonObject();
            JsonArray precipitaciones = dias.getAsJsonArray("dia");

            for (int i = 0; i < precipitaciones.size(); i++) {
                JsonObject basePrecioDia = precipitaciones.get(i).getAsJsonObject();
                JsonPrimitive fechaPrecio = basePrecioDia.getAsJsonPrimitive("fecha");
                String fecha = new Fecha(fechaPrecio.getAsString()).getDiaSemanaConvertido();
                JsonElement temp = basePrecioDia.getAsJsonObject("temperatura");
                JsonObject tempOb = temp.getAsJsonObject();
                String maxima = tempOb.get("maxima").getAsString();
                String minima = tempOb.get("minima").getAsString();
                data.add(new Tiempo(fecha, maxima, minima));
            }
        } catch (IllegalStateException ex) {
            MainController.getSingleton().setErrorFromAEMET("NO SE HA PODIDO PARSEAR, PORFAVOR, INTÉNTELO MÁS TARDE.");
        }
        return data;
    }
}
