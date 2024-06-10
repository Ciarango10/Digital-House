package com.example.Estudiantes.service;

import com.example.Estudiantes.entity.dto.MateriaDTO;

import java.util.List;

public interface IMateriaService {

    void crearMateria(MateriaDTO materiaDTO);
    void modificarMateria(MateriaDTO materiaDTO);
    MateriaDTO buscarMateriaPorId(Long id);
    List<MateriaDTO> listarMaterias();
    void eliminarMateriaPorId(Long id);

}
