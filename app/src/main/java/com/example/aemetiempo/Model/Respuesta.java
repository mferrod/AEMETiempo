package com.example.aemetiempo.Model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.LinkedList;
import java.util.List;

public class Respuesta {
    protected String datosJson;
    public Respuesta(String json) {
        datosJson = json;
    }

    public List<Tiempo> getData() {
        LinkedList<Tiempo> data = new LinkedList<>();

        JsonElement jsonElement = JsonParser.parseString(this.datosJson);
        JsonObject jsonObject = jsonElement.getAsJsonArray().getAsJsonObject().get("prediccion").getAsJsonObject();
        return data;
    }
}
