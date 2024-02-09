package com.backend.clase.model;

public class Mail {
    private String asunto;
    private String origen;
    private String destino;

    //alt+insert

    public Mail(String asunto, String origen, String destino) {
        this.asunto = asunto;
        this.origen = origen;
        this.destino = destino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
