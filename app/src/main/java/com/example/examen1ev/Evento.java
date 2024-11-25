package com.example.examen1ev;

public class Evento {

    private String deporte;
    private String partido;
    private String deportistas;
    private String resultado;
    private String valoracion;


    public Evento(String deporte, String partido, String deportistas, String resultado, String valoracion) {
        this.deporte = deporte;
        this.partido = partido;
        this.deportistas = deportistas;
        this.resultado = resultado;
        this.valoracion = valoracion;
    }

    public String toString(){
        return this.deporte + "," +this.partido + "," + this.deportistas +
            "," + this.resultado + "," + this.valoracion;
    }

    public Evento (String eventoString){
        String[] arrayEvento = eventoString.split(",");
        this.deporte = arrayEvento[0];
        this.partido = arrayEvento[1];
        this.deportistas = arrayEvento[2];
        this.resultado = arrayEvento[3];
        this.valoracion = arrayEvento[4];
    }

}
