package com.example.demo.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Leccion> lecciones;   
    
    // mappedBy apunta a la lista "inscripciones" que acabamos de poner en Estudiante
    @ManyToMany(mappedBy = "inscripciones")
    private List<Estudiante> estudiantes; 

    // Constructor vacío
    public Curso() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Leccion> getLecciones() {
        return lecciones;
    }

    public void setLecciones(List<Leccion> lecciones) {
        this.lecciones = lecciones;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}