package com.backend.clase.handlers;

import com.backend.clase.model.Mail;

public class ManejadorSpam extends ManejadorMail{

    @Override
    public String procesarMail(Mail mail) {
        System.out.println("Spameando...");
        return "SPAM";
    }
}
