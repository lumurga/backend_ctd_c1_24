package com.backend.clase13.service;

import com.backend.clase13.entity.Odontologo;
import com.backend.clase13.entity.Paciente;

import java.util.List;

public interface IOdontologoService {
    Odontologo registrarOdontologo();
    List<Paciente> listarPacientes();
    Paciente buscarPacientePorId(int id);
}
