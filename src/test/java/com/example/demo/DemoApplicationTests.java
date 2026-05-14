package com.example.demo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entidades.Curso;
import com.example.demo.repositorios.CursoRepository;

@SpringBootTest
class DemoApplicationTests {

    // Le pedimos a Spring que nos traiga el repositorio automáticamente
    @Autowired
    private CursoRepository cursoRepository;

    @Test
    void comprobarQueElRepositorioGuardaYLeeCursos() {
        // 1. PREPARACIÓN (Arrange): Creamos un curso de prueba
        Curso cursoPrueba = new Curso();
        cursoPrueba.setTitulo("Curso de Testing Automático");
        cursoPrueba.setDescripcion("Aprende a evitar bugs en producción.");

        // 2. ACCIÓN (Act): Lo guardamos y luego lo buscamos por su ID generado
        Curso cursoGuardado = cursoRepository.save(cursoPrueba);
        Optional<Curso> cursoRecuperado = cursoRepository.findById(cursoGuardado.getId());

        // 3. COMPROBACIÓN (Assert): Verificamos que todo ha ido bien
        
        // Comprobamos que la búsqueda realmente encontró algo (no es nulo)
        assertTrue(cursoRecuperado.isPresent(), "El curso debería existir en la base de datos");
        
        // Comprobamos que el título del curso que sacamos de la BD es exactamente el que guardamos
        assertEquals("Curso de Testing Automático", cursoRecuperado.get().getTitulo(), "El título no coincide");
    }
}