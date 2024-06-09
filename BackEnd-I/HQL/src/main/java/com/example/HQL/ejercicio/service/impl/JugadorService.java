package com.example.HQL.ejercicio.service.impl;

import com.example.HQL.ejercicio.entity.Jugador;
import com.example.HQL.ejercicio.repository.IJugadorRepository;
import com.example.HQL.ejercicio.service.IJugadorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService implements IJugadorService {

    private IJugadorRepository jugadorRepository;

    public JugadorService(IJugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    public Jugador agregarJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public List<Jugador> listarJugadores() {
        return jugadorRepository.findAll();
    }

    @Override
    public Jugador buscarJugadorPorNombre(String nombre) {
        return jugadorRepository.findByName(nombre).get();
    }

}
