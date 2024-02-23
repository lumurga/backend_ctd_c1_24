package com.backend.test;

import com.backend.dao.impl.PacienteDaoH2;
import com.backend.dao.impl.PacienteDaoMemoria;
import com.backend.entity.Domicilio;
import com.backend.entity.Paciente;
import com.backend.service.impl.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {

    private PacienteService pacienteService;

    @Test
    void deberiaRegistrarUnPacienteYRetornarUnIdEnH2(){
        pacienteService = new PacienteService(new PacienteDaoH2());
        Paciente paciente = new Paciente("Nombre", "Apellido", 123456, LocalDate.of(2023, 05, 02), new Domicilio("Calle", 13, "Localidad", "Provincia"));

        Paciente pacienteRegistrado = pacienteService.registrarPaciente(paciente);

        Assertions.assertTrue(pacienteRegistrado.getId() != 0);

    }

    @Test
    void deberiaRegistrarUnPacienteYRetornarUnIdEnMemoria(){
        pacienteService = new PacienteService(new PacienteDaoMemoria(new ArrayList<>()));
        Paciente paciente = new Paciente("Nombre", "Apellido", 123456, LocalDate.of(2023, 05, 02), new Domicilio("Calle", 13, "Localidad", "Provincia"));

        Paciente pacienteRegistrado = pacienteService.registrarPaciente(paciente);

        Assertions.assertTrue(pacienteRegistrado.getId() != 0);

    }


}