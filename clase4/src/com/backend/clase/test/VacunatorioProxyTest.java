package com.backend.clase.test;

import com.backend.clase.model.Persona;
import com.backend.clase.proxy.Vacunatorio;
import com.backend.clase.proxy.VacunatorioProxy;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacunatorioProxyTest {
    private Vacunatorio vacunatorio = new VacunatorioProxy();

    @Test
    void siLaPersonaConcurreAntesDeFechaAsignada_noDeberiaSerVacunada(){

        //arrange
        Persona persona = new Persona("Juan Perez", "11111111", "AntiGripal", LocalDate.of(2024, 02, 15));
        String rtaEsperada = "La fecha no se corresponde con la fecha asignada";

        //act
        String rtaObtenida = vacunatorio.vacunar(persona);

        //assert
        assertEquals(rtaEsperada, rtaObtenida);

    }
}