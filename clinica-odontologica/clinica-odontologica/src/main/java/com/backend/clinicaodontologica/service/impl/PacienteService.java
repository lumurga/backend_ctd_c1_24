package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dao.IDao;
import com.backend.clinicaodontologica.entity.Paciente;
import com.backend.clinicaodontologica.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteIDao.registrar(paciente);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteIDao.listarTodos();
    }

    @Override
    public Paciente buscarPacientePorId(int id) {
        return pacienteIDao.buscarPorId(id);
    }
}
