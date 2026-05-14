package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Curso;
import com.example.demo.repositorios.CursoRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cursos") // Base de la URL para este controlador
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> obtenerTodosLosCursos() {
        // Devuelve todos los cursos de la base de datos
        return cursoRepository.findAll();
    }

    // 1. RECIBIR (Crear un curso nuevo)
    @PostMapping
    public Curso crearCurso(@RequestBody Curso nuevoCurso) {
        // Tomamos el JSON que nos envían y lo guardamos en la base de datos
        return cursoRepository.save(nuevoCurso);
    }

    // 2. ACTUALIZAR (Modificar un curso que ya existe)
    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable Long id, @RequestBody Curso cursoActualizado) {
        return cursoRepository.findById(id)
            .map(curso -> {
                curso.setTitulo(cursoActualizado.getTitulo());
                curso.setDescripcion(cursoActualizado.getDescripcion());
                return cursoRepository.save(curso);
            })
            .orElseGet(() -> {
                cursoActualizado.setId(id);
                return cursoRepository.save(cursoActualizado);
            });
    }
}