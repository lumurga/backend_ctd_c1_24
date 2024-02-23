package com.backend.service;

import com.backend.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente registrarPaciente(Paciente paciente);
    List<Paciente> listarPacientes();
    Paciente buscarPacientePorId(int id);
}
