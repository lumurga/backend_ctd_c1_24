package com.backend.clase.proxy;

import com.backend.clase.model.Persona;

public class VacunatorioService implements Vacunatorio{
    @Override
    public String vacunar(Persona persona) {
        System.out.println("Recibiendo a " + persona.getNombre());
        return "Se ha registrado a la persona con DNI " + persona.getDni() + ", fue vacunada con " + persona.getVacuna();
    }
}
