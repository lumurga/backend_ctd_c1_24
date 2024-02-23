package com.backend.dao.impl;

import com.backend.dao.IDao;
import com.backend.entity.Domicilio;
import com.backend.entity.Paciente;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PacienteDaoMemoria implements IDao<Paciente> {
    private final Logger LOGGER = Logger.getLogger(PacienteDaoMemoria.class);
    private List<Paciente> pacienteRepository;


    public PacienteDaoMemoria(List<Paciente> pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente registrar(Paciente paciente) {
        int id = pacienteRepository.size() + 1;
        Domicilio domicilioGuardado = paciente.getDomicilio();
        domicilioGuardado.setId(id);
        Paciente pacienteGuardado = new Paciente(id, paciente.getNombre(), paciente.getApellido(), paciente.getDni(), paciente.getFechaIngreso(), domicilioGuardado);

        pacienteRepository.add(paciente);
        LOGGER.info("Paciente guardado: " + pacienteGuardado);
        return pacienteGuardado;
    }

    @Override
    public Paciente buscarPorId(int id) {
        return null;
    }

    @Override
    public List<Paciente> listarTodos() {
        return null;
    }
}
