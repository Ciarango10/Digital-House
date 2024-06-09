package com.example.HQL.ejercicio.controller;

import com.example.HQL.ejercicio.entity.Jugador;
import com.example.HQL.ejercicio.service.IJugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    private IJugadorService jugadorService;

    public JugadorController(IJugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping()
    public List<Jugador> listarJugadores() {
        return jugadorService.listarJugadores();
    }

    @GetMapping("/{nombre}")
    public Jugador obtenerJugadorPorNombre(@PathVariable String nombre) {
        return jugadorService.buscarJugadorPorNombre(nombre);
    }

    @PostMapping
    public Jugador agregarJugador(@RequestBody Jugador jugador) {
        return jugadorService.agregarJugador(jugador);
    }

}
