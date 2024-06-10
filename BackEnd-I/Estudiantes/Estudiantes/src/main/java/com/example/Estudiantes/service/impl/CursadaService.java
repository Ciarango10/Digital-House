package com.example.Estudiantes.service.impl;

import com.example.Estudiantes.entity.Cursada;
import com.example.Estudiantes.entity.dto.CursadaDTO;
import com.example.Estudiantes.repository.ICursadaRepository;
import com.example.Estudiantes.service.ICursadaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursadaService implements ICursadaService {

    private ICursadaRepository cursadaRepository;
    private ObjectMapper mapper;

    public CursadaService(ICursadaRepository cursadaRepository, ObjectMapper mapper) {
        this.cursadaRepository = cursadaRepository;
        this.mapper = mapper;
    }


    @Override
    public void crearCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public void modificarCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public CursadaDTO buscarCursadaPorId(Long id) {
        Optional<Cursada> cursada = cursadaRepository.findById(id);
        CursadaDTO cursadaDTO = null;
        if(cursada.isPresent()) {
            cursadaDTO = mapper.convertValue(cursada, CursadaDTO.class);
        }
        return cursadaDTO;
    }

    @Override
    public List<CursadaDTO> listarCursadas() {
        List<Cursada> cursadas = cursadaRepository.findAll();
        List<CursadaDTO> cursadasDTO = new ArrayList<>();

        for (Cursada cursada: cursadas) {
            cursadasDTO.add(mapper.convertValue(cursada, CursadaDTO.class));
        }

        return cursadasDTO;
    }

    @Override
    public void eliminarCursadaPorId(Long id) {
        cursadaRepository.deleteById(id);
    }

}
