package com.example.demo.controladores;

import com.example.demo.entidades.Estudiante;
import com.example.demo.repositorios.EstudianteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@Tag(name = "Estudiantes", description = "Gestión de alumnos de EduTech")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    @Operation(summary = "Listar todos los estudiantes", description = "Devuelve una lista con todos los alumnos registrados en el sistema")
    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }
}