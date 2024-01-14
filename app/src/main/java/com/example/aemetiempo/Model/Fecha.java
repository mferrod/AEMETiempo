package com.example.aemetiempo.Model;

import java.time.LocalDate;
import java.util.Calendar;

public class Fecha {
    private String diaSemanaConvertido;
    public Fecha(String fecha) {
        this.parseaFecha(fecha);
    }
    private void parseaFecha(String fecha) {
        String parseado = fecha.substring(0, fecha.indexOf("T"));
        convertirDiaSemana(parseado);
    }
    private void convertirDiaSemana(String fechaParseada) {
        String dia = String.valueOf(LocalDate.parse(fechaParseada).getDayOfWeek());
        switch (dia) {
            case "MONDAY":
                this.diaSemanaConvertido = "Lunes";
                break;
            case "TUESDAY":
                this.diaSemanaConvertido = "Martes";
                break;
            case "WEDNESDAY":
                this.diaSemanaConvertido = "Miércoles";
                break;
            case "THURSDAY":
                this.diaSemanaConvertido = "Jueves";
                break;
            case "FRIDAY":
                this.diaSemanaConvertido = "Viernes";
                break;
            case "SATURDAY":
                this.diaSemanaConvertido = "Sábado";
                break;
            case "SUNDAY":
                this.diaSemanaConvertido = "Domingo";
                break;
        }
    }
    public String getDiaSemanaConvertido() {
        return this.diaSemanaConvertido;
    }
}
