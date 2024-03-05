package com.backend.clinicaodontologica.service;


import com.backend.clinicaodontologica.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente registrarPaciente(Paciente paciente);

    List<Paciente> listarPacientes();

    Paciente buscarPacientePorId(int id);
}
