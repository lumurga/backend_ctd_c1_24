package com.backend.clase13.service;



import com.backend.clase13.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente registrarPaciente(Paciente paciente);
    List<Paciente> listarPacientes();
    Paciente buscarPacientePorId(int id);
}
