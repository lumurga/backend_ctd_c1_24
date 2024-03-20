package com.backend.clinicaodontologica.service;

import com.backend.clinicaodontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.PacienteSalidaDto;
import com.backend.clinicaodontologica.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

    List<OdontologoSalidaDto> listarOdontologos();

    OdontologoSalidaDto buscarOdontologoPorId(Long id);
    void eliminarOdontologo(Long id);
    OdontologoSalidaDto modificarOdontologo(OdontologoEntradaDto odontologoEntradaDto, Long id);
}
