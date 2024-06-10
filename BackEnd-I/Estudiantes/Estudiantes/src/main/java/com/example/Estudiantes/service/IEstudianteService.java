package com.example.Estudiantes.service;

import com.example.Estudiantes.entity.dto.EstudianteDTO;

import java.util.List;

public interface IEstudianteService {

    void crearEstudiante(EstudianteDTO estudianteDTO);
    void modificarEstudiante(EstudianteDTO estudianteDTO);
    EstudianteDTO buscarEstudiantePorId(Long id);
    List<EstudianteDTO> listarEstudiantes();
    void eliminarEstudiantePorId(Long id);

}
