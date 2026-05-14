package com.example.demo.controladores;

import com.example.demo.entidades.Leccion;
import com.example.demo.repositorios.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lecciones") // <--- Dirección para las lecciones
public class LeccionController {

    @Autowired
    private LeccionRepository leccionRepository; // <--- Inyecta el repositorio de lecciones

    @GetMapping
    public List<Leccion> obtenerTodasLasLecciones() {
        // Llama al repositorio para obtener todas las lecciones
        return leccionRepository.findAll();
    }
}