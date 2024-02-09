package com.backend.clase.handlers;

import com.backend.clase.model.Mail;

public class ManejadorTecnico extends ManejadorMail{
    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Area Tecnica trabajando...");
        String respuesta;
        if(mail.getAsunto().equalsIgnoreCase("tecnica") || mail.getDestino().equals("tecnica@colmena.com")) respuesta = "Area Tecnica mail...";
         else respuesta = getSiguienteManejador().procesarMail(mail);

        return respuesta;
    }
}
