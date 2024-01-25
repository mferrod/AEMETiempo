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
            JsonObject arrayPredicciones = jsonArray.get(0).getAsJsonObject();
            JsonElement predicciones = arrayPredicciones.get("prediccion");
            JsonObject diasDePredicciones = predicciones.getAsJsonObject();
            JsonArray precipitaciones = diasDePredicciones.getAsJsonArray("dia");

            for (int i = 0; i < precipitaciones.size(); i++) {
                JsonObject basePrecioDia = precipitaciones.get(i).getAsJsonObject();
                JsonPrimitive fechaPrecio = basePrecioDia.getAsJsonPrimitive("fecha");
                JsonElement temperatura = basePrecioDia.getAsJsonObject("temperatura");
                JsonObject temperaturaObject = temperatura.getAsJsonObject();
                int j = 0;
                while (basePrecioDia.get("estadoCielo").getAsJsonArray().get(j).getAsJsonObject().get("descripcion").getAsString().equals(""))
                    j++;
                data.add(new Tiempo(new Fecha(fechaPrecio.getAsString()).getDiaSemanaConvertido(),
                        temperaturaObject.get("maxima").getAsString() + "º",
                        temperaturaObject.get("minima").getAsString() + "º",
                        basePrecioDia.get("estadoCielo").getAsJsonArray().get(j).getAsJsonObject().get("descripcion").getAsString()));
            }
        } catch (IllegalStateException ex) {
            MainController.getSingleton().setErrorFromAEMET("NO SE HA PODIDO PARSEAR, PORFAVOR, INTÉNTELO MÁS TARDE.");
        }
        return data;
    }
}
