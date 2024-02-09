package com.backend.clase.proxy;

import com.backend.clase.model.Persona;

import java.time.LocalDate;

public class VacunatorioProxy implements Vacunatorio{

    private VacunatorioService vacunatorioService;

    @Override
    public String vacunar(Persona persona) {
        //controlar fecha
        String respuesta = "La fecha no se corresponde con la fecha asignada";
        if(validarFecha(persona.getFechaAsignada())){
            vacunatorioService = new VacunatorioService();
            respuesta = vacunatorioService.vacunar(persona);
        }

        return respuesta;
    }

    private boolean validarFecha(LocalDate fecha){
        LocalDate hoy = LocalDate.now();
        return !hoy.isBefore(fecha);
    }


}
