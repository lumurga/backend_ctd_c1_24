package com.backend.clase13.service;

import com.backend.clase13.entity.Odontologo;


import java.util.List;

public interface IOdontologoService {
    Odontologo registrarOdontologo(Odontologo odontologo);
    List<Odontologo> listarOdontologos();
    Odontologo buscarOdontologoPorId(int id);
}
