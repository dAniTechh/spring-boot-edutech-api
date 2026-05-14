package com.example.demo.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity // Indica que es una tabla en la BD [cite: 174]
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Leccion {
    @Id // Clave única [cite: 211]
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    private String titulo;
    private String contenidoUrl;

    @ManyToOne // Muchas lecciones pertenecen a un curso [cite: 432]
    @JoinColumn(name = "curso_id") // Columna de unión en la tabla [cite: 463]
    private Curso curso;
}