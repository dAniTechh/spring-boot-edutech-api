package com.example.demo.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    // Un curso tiene muchas lecciones.
    // 'mappedBy' indica que la relación la "manda" el campo 'curso' en la clase Leccion [cite: 482]
    // 'cascade' asegura que si guardas/borras un curso, afecte a sus lecciones [cite: 484]
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Leccion> lecciones;   
    // El 'mappedBy' apunta al nombre de la variable en la clase Estudiante
    @ManyToMany(mappedBy = "cursos")
    private List<Estudiante> estudiantes; 
}