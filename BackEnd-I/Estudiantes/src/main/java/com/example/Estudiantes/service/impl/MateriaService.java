package com.example.Estudiantes.service.impl;

import com.example.Estudiantes.entity.Materia;
import com.example.Estudiantes.entity.dto.MateriaDTO;
import com.example.Estudiantes.repository.IMateriaRepository;
import com.example.Estudiantes.service.IMateriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService implements IMateriaService {

    private IMateriaRepository materiaRepository;
    private ObjectMapper mapper;

    public MateriaService(IMateriaRepository materiaRepository, ObjectMapper mapper) {
        this.materiaRepository = materiaRepository;
        this.mapper = mapper;
    }

    @Override
    public void crearMateria(MateriaDTO materiaDTO) {
        Materia materia = mapper.convertValue(materiaDTO, Materia.class);
        materiaRepository.save(materia);
    }

    @Override
    public void modificarMateria(MateriaDTO materiaDTO) {
        Materia materia = mapper.convertValue(materiaDTO, Materia.class);
        materiaRepository.save(materia);
    }

    @Override
    public MateriaDTO buscarMateriaPorId(Long id) {
        Optional<Materia> materia = materiaRepository.findById(id);
        MateriaDTO materiaDTO = null;
        if(materia.isPresent()) {
            materiaDTO = mapper.convertValue(materia, MateriaDTO.class);
        }
        return materiaDTO;
    }

    @Override
    public List<MateriaDTO> listarMaterias() {
        List<Materia> materias = materiaRepository.findAll();
        List<MateriaDTO> materiasDTO = new ArrayList<>();

        for (Materia materia: materias) {
            materiasDTO.add(mapper.convertValue(materia, MateriaDTO.class));
        }

        return materiasDTO;
    }

    @Override
    public void eliminarMateriaPorId(Long id) {
        materiaRepository.deleteById(id);
    }

}
