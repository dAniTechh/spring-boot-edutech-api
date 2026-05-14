package com.example.demo.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String inicio() {
        return "Servidor funcionando. Prueba a escribir tu nombre en la URL";
    }

    @GetMapping("/saludo/{nombre}")
    public String saluda(@PathVariable String nombre) {
        return "Hola " + nombre;
    }
}