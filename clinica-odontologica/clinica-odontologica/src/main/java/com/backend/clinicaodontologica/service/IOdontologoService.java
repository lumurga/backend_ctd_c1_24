package com.backend.clinicaodontologica.service;

import com.backend.clinicaodontologica.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    Odontologo registrarOdontologo(Odontologo odontologo);

    List<Odontologo> listarOdontologos();

    Odontologo buscarOdontologoPorId(int id);
}
