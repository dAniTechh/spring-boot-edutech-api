package com.example.demo.config;

import com.example.demo.entidades.Curso;
import com.example.demo.entidades.Estudiante;
import com.example.demo.entidades.Leccion;
import com.example.demo.repositorios.CursoRepository;
import com.example.demo.repositorios.EstudianteRepository;
import com.example.demo.repositorios.LeccionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(CursoRepository cursoRepo, 
                                   LeccionRepository leccionRepo, 
                                   EstudianteRepository estudianteRepo) {
        return args -> {
            // 1. Creamos un curso de programación
            Curso cursoJava = new Curso();
            cursoJava.setTitulo("Master en Java y Spring Boot");
            cursoJava.setDescripcion("De cero a experto en backend profesional.");
            cursoRepo.save(cursoJava);

            // 2. Añadimos lecciones al curso de Java
            Leccion l1 = new Leccion();
            l1.setTitulo("Introducción a JPA");
            l1.setContenidoUrl("https://edutech.com/video1");
            l1.setCurso(cursoJava);

            Leccion l2 = new Leccion();
            l2.setTitulo("Magia con Repositorios");
            l2.setContenidoUrl("https://edutech.com/video2");
            l2.setCurso(cursoJava);

            leccionRepo.saveAll(Arrays.asList(l1, l2));

            // 3. Creamos un curso de deporte (para variar los datos)
            Curso cursoGym = new Curso();
            cursoGym.setTitulo("Fundamentos de Atleta Híbrido");
            cursoGym.setDescripcion("Optimización de fuerza y resistencia.");
            cursoRepo.save(cursoGym);

            // 4. Te creamos a ti como estudiante
            Estudiante daniel = new Estudiante();
            daniel.setNombre("Daniel García Boillos");
            daniel.setEmail("daniel.garcia@example.com");
            
            // Te inscribimos en ambos cursos
            daniel.setInscripciones(Arrays.asList(cursoJava, cursoGym));
            estudianteRepo.save(daniel);

            System.out.println("¡Datos de prueba cargados con éxito!");
        };
    }
}