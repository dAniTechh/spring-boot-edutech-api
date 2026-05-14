package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Curso;
import com.example.demo.repositorios.CursoRepository;

@RestController
@RequestMapping("/api/cursos") // Base de la URL para este controlador
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> obtenerTodosLosCursos() {
        // La magia de JPA: devuelve todos los cursos de la base de datos como una lista
        return cursoRepository.findAll();
    }
}