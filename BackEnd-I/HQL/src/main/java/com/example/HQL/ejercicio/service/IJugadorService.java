package com.example.HQL.ejercicio.service;

import com.example.HQL.ejercicio.entity.Jugador;

import java.util.List;

public interface IJugadorService {

    Jugador agregarJugador (Jugador jugador);
    List<Jugador> listarJugadores ();
    Jugador buscarJugadorPorNombre(String nombre);

}
