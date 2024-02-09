package com.backend.clase.model;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String dni;
    private String vacuna;
    private LocalDate fechaAsignada;

    public Persona(String nombre, String dni, String vacuna, LocalDate fechaAsignada) {
        this.nombre = nombre;
        this.dni = dni;
        this.vacuna = vacuna;
        this.fechaAsignada = fechaAsignada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public LocalDate getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(LocalDate fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }
}
