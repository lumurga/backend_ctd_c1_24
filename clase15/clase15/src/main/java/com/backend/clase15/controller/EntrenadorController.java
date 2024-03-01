package com.backend.clase15.controller;

import com.backend.clase15.entity.Entrenador;
import com.backend.clase15.service.IEntrenadorService;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    private IEntrenadorService entrenadorService;

    public EntrenadorController(IEntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping("/pepito")
    public List<Entrenador> listarEntrenador(){
        return entrenadorService.listarEntrenadores();
    }
}
