package com.backend.clase.service;

import com.backend.clase.handlers.*;
import com.backend.clase.model.Mail;

public class MailService {
    //se encarga de definir la cadena e iniciar el proceso

    private ManejadorMail primerManejador;

    public MailService() {
        //primer eslabon
        primerManejador = new ManejadorTecnico();

        //segundo eslabon
        ManejadorMail segundoManejador = new ManejadorComercial();
        primerManejador.setSiguienteManejador(segundoManejador);

        //tercer eslabon
        ManejadorMail tercerManejador = new ManejadorGerencial();
        segundoManejador.setSiguienteManejador(tercerManejador);

        //cuarto eslabon
        ManejadorMail cuartoManejador = new ManejadorSpam();
        tercerManejador.setSiguienteManejador(cuartoManejador);

    }

    public String procesarMail(Mail mail){
        return primerManejador.procesarMail(mail);
    }
}
