package com.example.Estudiantes.repository;

import com.example.Estudiantes.entity.Cursada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursadaRepository extends JpaRepository<Cursada, Long> {
}
