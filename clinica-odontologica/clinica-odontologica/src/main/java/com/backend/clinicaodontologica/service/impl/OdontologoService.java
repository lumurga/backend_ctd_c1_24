package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dao.IDao;
import com.backend.clinicaodontologica.entity.Odontologo;
import com.backend.clinicaodontologica.service.IOdontologoService;

import java.util.List;

public class OdontologoService implements IOdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoIDao.registrar(odontologo);
    }

    public Odontologo buscarOdontologoPorId(int id) {
        return odontologoIDao.buscarPorId(id);
    }

    public List<Odontologo> listarOdontologos() {
        return odontologoIDao.listarTodos();
    }


}
