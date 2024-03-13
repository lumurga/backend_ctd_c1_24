package com.backend.clase22.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROFESORES")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String titulo;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.REMOVE)
    private List<Alumno> alumnos;

    public Profesor() {
    }

    public Profesor(Long id, String nombre, String titulo, List<Alumno> alumnos) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.alumnos = alumnos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
