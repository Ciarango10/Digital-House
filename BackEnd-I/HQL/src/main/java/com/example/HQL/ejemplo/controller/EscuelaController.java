package com.example.HQL.ejemplo.controller;

import com.example.HQL.ejemplo.entity.Escuela;
import com.example.HQL.ejemplo.service.EscuelaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escuelas")
public class EscuelaController {

    private EscuelaServicio escuelaServicio;

    public EscuelaController(EscuelaServicio escuelaServicio) {
        this.escuelaServicio = escuelaServicio;
    }

    @GetMapping
    public List<Escuela> listarEscuelas() {
        return escuelaServicio.listarEscuelas();
    }

    @GetMapping("/{direccion}")
    public Escuela buscarEscuelaPorDireccion(@PathVariable String direccion) {
        return escuelaServicio.buscarEscuelaPorDireccion(direccion);
    }

    @PostMapping
    public Escuela agregarEscuela(@RequestBody Escuela escuela) {
        return escuelaServicio.agregarEscuela(escuela);
    }

}
