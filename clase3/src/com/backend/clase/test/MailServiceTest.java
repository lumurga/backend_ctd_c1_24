package com.backend.clase.test;

import com.backend.clase.model.Mail;
import com.backend.clase.service.MailService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailServiceTest {
    private final MailService mailService = new MailService();

    @Test
    void cuandoElDestinoNoSeaParaNingunDepartamento_oElAsuntoNoNombreUnDepartamento_deberiaProcesarseComoSpam(){
        //arrange
        Mail mail = new Mail("lkuylkjghlkjh", "lu@gmail.com", "ldkjghdi@colmena.com");
        String respuestaEsperada = "SPAM";
        //act
        String respuestaObtenida = mailService.procesarMail(mail);
        //assert
        assertEquals(respuestaEsperada, respuestaObtenida);

    }


}