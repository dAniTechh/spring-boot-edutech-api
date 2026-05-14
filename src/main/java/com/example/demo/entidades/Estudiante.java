package com.example.demo.entidades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;

    @ManyToMany
    @JoinTable(
        name = "inscripciones", 
        joinColumns = @JoinColumn(name = "estudiante_id"), 
        inverseJoinColumns = @JoinColumn(name = "curso_id") 
    )
    @JsonIgnore
    private List<Curso> inscripciones;

    // Constructor vacío (obligatorio para JPA)
    public Estudiante() {
    }

    // Getters y Setters generados a mano (Adiós Lombok)
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Curso> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Curso> inscripciones) {
        this.inscripciones = inscripciones;
    }
}