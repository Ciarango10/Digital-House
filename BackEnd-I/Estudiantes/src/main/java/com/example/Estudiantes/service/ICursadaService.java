package com.example.Estudiantes.service;

import com.example.Estudiantes.entity.dto.CursadaDTO;

import java.util.List;

public interface ICursadaService {

    void crearCursada(CursadaDTO cursadaDTO);
    void modificarCursada(CursadaDTO cursadaDTO);
    CursadaDTO buscarCursadaPorId(Long id);
    List<CursadaDTO> listarCursadas();
    void eliminarCursadaPorId(Long id);

}
