package com.backend.clinicaodontologica.controller;

import com.backend.clinicaodontologica.entity.Paciente;
import com.backend.clinicaodontologica.service.IPacienteService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@ResponseBody + @Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //GET
    @GetMapping()
    public List<Paciente> listarPacientes(){
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}") //localhost:8080/pacientes/x
    public Paciente buscarPacientePorId(@PathVariable int id){
        return pacienteService.buscarPacientePorId(id);
    }


    //POST
    @PostMapping("/registrar")
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.registrarPaciente(paciente);
    }


    //PUT
    @PutMapping("/actualizar/{id}")//localhost:8080/pacientes/actualizar/x
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
       return null; //pacienteService.actualizar(paciente);
    }

    //DELETE
    @DeleteMapping("/eliminar")//localhost:8080/pacientes/eliminar?id=x
    public void eliminarPaciente(@RequestParam int id){
        //pacienteService.eliminarPaciente(id);
    }


}
