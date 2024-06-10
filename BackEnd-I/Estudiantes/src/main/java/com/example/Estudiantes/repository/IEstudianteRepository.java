package com.example.Estudiantes.repository;

import com.example.Estudiantes.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {
}
