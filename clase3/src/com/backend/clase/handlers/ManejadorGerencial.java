package com.backend.clase.handlers;

import com.backend.clase.model.Mail;

public class ManejadorGerencial extends ManejadorMail {
    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Gerencia trabajando...");
        String respuesta = "";
        if(mail.getAsunto().equalsIgnoreCase("gerencia") || mail.getDestino().equals("gerencia@colmena.com")) respuesta = "Gerencia procesando mail...";
         else respuesta = getSiguienteManejador().procesarMail(mail);

        return respuesta;
    }

}
