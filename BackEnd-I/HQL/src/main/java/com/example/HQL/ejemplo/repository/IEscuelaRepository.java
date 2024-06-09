package com.example.HQL.ejemplo.repository;

import com.example.HQL.ejemplo.entity.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IEscuelaRepository extends JpaRepository<Escuela, Long> {

    @Query("SELECT e FROM Escuela e WHERE e.direccion = ?1")
    Optional<Escuela> findByDireccion(String direccion);

}
