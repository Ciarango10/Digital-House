package com.example.HQL.ejercicio.repository;

import com.example.HQL.ejercicio.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IJugadorRepository extends JpaRepository<Jugador, Long> {

    @Query("SELECT j FROM Jugador j WHERE j.nombre = ?1")
    Optional<Jugador> findByName(String nombre);

}
