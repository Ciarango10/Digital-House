package com.example.Estudiantes.service.impl;

import com.example.Estudiantes.entity.Estudiante;
import com.example.Estudiantes.entity.dto.EstudianteDTO;
import com.example.Estudiantes.repository.IEstudianteRepository;
import com.example.Estudiantes.service.IEstudianteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService implements IEstudianteService {

    private IEstudianteRepository estudianteRepository;
    private ObjectMapper mapper;

    public EstudianteService(IEstudianteRepository estudianteRepository, ObjectMapper mapper) {
        this.estudianteRepository = estudianteRepository;
        this.mapper = mapper;
    }

    @Override
    public void crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override
    public void modificarEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override
    public EstudianteDTO buscarEstudiantePorId(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        EstudianteDTO estudianteDTO = null;
        if(estudiante.isPresent()) {
            estudianteDTO = mapper.convertValue(estudiante, EstudianteDTO.class);
        }
        return estudianteDTO;
    }

    @Override
    public List<EstudianteDTO> listarEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

        for (Estudiante estudiante: estudiantes) {
            estudiantesDTO.add(mapper.convertValue(estudiante, EstudianteDTO.class));
        }

        return estudiantesDTO;
    }

    @Override
    public void eliminarEstudiantePorId(Long id) {
        estudianteRepository.deleteById(id);
    }

}
