package com.example.demo.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;

    // Aquí definimos la relación de Muchos a Muchos
    @ManyToMany
    @JoinTable(
        name = "inscripciones", // Así se llamará la tabla intermedia en la base de datos
        joinColumns = @JoinColumn(name = "estudiante_id"), // Columna para el ID del estudiante
        inverseJoinColumns = @JoinColumn(name = "curso_id") // Columna para el ID del curso
    )
    private List<Curso> cursos;
}