package com.backend.clase.handlers;

import com.backend.clase.model.Mail;

public class ManejadorComercial extends ManejadorMail{


    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Area comercial trabajando...");
        String respuesta;
        if(mail.getAsunto().equalsIgnoreCase("comercial") || mail.getDestino().equals("comercial@colmena.com")) respuesta = "area comercial procesando el mail";
        else respuesta = getSiguienteManejador().procesarMail(mail);

        return respuesta;
    }
}
