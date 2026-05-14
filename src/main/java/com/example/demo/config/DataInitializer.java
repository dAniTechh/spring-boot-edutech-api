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
            // ==========================================
            // 1. CURSO DE PROGRAMACIÓN BACKEND
            // ==========================================
            Curso cursoJava = new Curso();
            cursoJava.setTitulo("Master en Java y Spring Boot");
            cursoJava.setDescripcion("De cero a experto en backend profesional y bases de datos relacionales.");
            cursoRepo.save(cursoJava);

            Leccion l1 = new Leccion();
            l1.setTitulo("Introducción a JPA e Hibernate");
            l1.setContenidoUrl("https://edutech.com/jpa");
            l1.setCurso(cursoJava);

            Leccion l2 = new Leccion();
            l2.setTitulo("Magia con Repositorios y Swagger");
            l2.setContenidoUrl("https://edutech.com/swagger");
            l2.setCurso(cursoJava);

            // ==========================================
            // 2. CURSO DE RENDIMIENTO DEPORTIVO
            // ==========================================
            Curso cursoGym = new Curso();
            cursoGym.setTitulo("Atleta Híbrido: Fuerza e Hipertrofia");
            cursoGym.setDescripcion("Planificación avanzada del entrenamiento, control de fatiga y programación de microciclos.");
            cursoRepo.save(cursoGym);
            
            Leccion l3 = new Leccion();
            l3.setTitulo("Gestión del RPE en rutinas de fuerza");
            l3.setContenidoUrl("https://edutech.com/rpe");
            l3.setCurso(cursoGym);

            Leccion l4 = new Leccion();
            l4.setTitulo("Método Cluster (3-4 4-3) en dominadas");
            l4.setContenidoUrl("https://edutech.com/cluster-dominadas");
            l4.setCurso(cursoGym);

            Leccion l5 = new Leccion();
            l5.setTitulo("Aislamiento: 4 series en extensión de cuádriceps");
            l5.setContenidoUrl("https://edutech.com/extension-piernas");
            l5.setCurso(cursoGym);

            // ==========================================
            // 3. CURSO DE DESARROLLO WEB FRONTEND
            // ==========================================
            Curso cursoFront = new Curso();
            cursoFront.setTitulo("Frontend React & Estilos Luxury");
            cursoFront.setDescripcion("Construye interfaces modernas, minimalistas y elegantes con React y Tailwind CSS.");
            cursoRepo.save(cursoFront);

            Leccion l6 = new Leccion();
            l6.setTitulo("Componentes y Hooks en React");
            l6.setContenidoUrl("https://edutech.com/react-hooks");
            l6.setCurso(cursoFront);

            Leccion l7 = new Leccion();
            l7.setTitulo("Diseño Minimalista con Tailwind CSS y Anime.js");
            l7.setContenidoUrl("https://edutech.com/tailwind-animations");
            l7.setCurso(cursoFront);

            // ==========================================
            // 4. CURSO DE REDES Y CIBERSEGURIDAD
            // ==========================================
            Curso cursoCiber = new Curso();
            cursoCiber.setTitulo("Ciberseguridad y Redes Avanzadas");
            cursoCiber.setDescripcion("Despliegue de firewalls, análisis de protocolos y seguridad en entornos corporativos.");
            cursoRepo.save(cursoCiber);

            Leccion l8 = new Leccion();
            l8.setTitulo("Configuración de reglas en pfSense");
            l8.setContenidoUrl("https://edutech.com/pfsense-rules");
            l8.setCurso(cursoCiber);

            Leccion l9 = new Leccion();
            l9.setTitulo("Análisis de tráfico con Wireshark y Kali Linux");
            l9.setContenidoUrl("https://edutech.com/wireshark");
            l9.setCurso(cursoCiber);

            // ==========================================
            // 5. CURSO DE MECÁNICA Y EFICIENCIA
            // ==========================================
            Curso cursoMotor = new Curso();
            cursoMotor.setTitulo("Mecánica Básica y Eficiencia GLP");
            cursoMotor.setDescripcion("Mantenimiento preventivo, consumos y optimización de motores bifuel.");
            cursoRepo.save(cursoMotor);

            Leccion l10 = new Leccion();
            l10.setTitulo("Optimización del consumo en motores 1.0 TCe");
            l10.setContenidoUrl("https://edutech.com/motor-tce");
            l10.setCurso(cursoMotor);

            // Guardamos todas las lecciones de golpe
            leccionRepo.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10));

            // ==========================================
            // 6. CREACIÓN DE ESTUDIANTES
            // ==========================================
            Estudiante daniel = new Estudiante();
            daniel.setNombre("Daniel García Boillos");
            daniel.setEmail("daniel.garcia@example.com");
            
            // Te inscribimos en todos los cursos para que tengas la cuenta llena
            daniel.setInscripciones(Arrays.asList(cursoJava, cursoGym, cursoFront, cursoCiber, cursoMotor));
            estudianteRepo.save(daniel);

            System.out.println("==========================================");
            System.out.println("¡BASE DE DATOS INICIALIZADA CON 5 CURSOS, 10 LECCIONES Y 1 ALUMNO!");
            System.out.println("==========================================");
        };
    }
}