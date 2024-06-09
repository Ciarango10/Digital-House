package com.example.HQL.ejemplo.service;

import com.example.HQL.ejemplo.entity.Escuela;
import com.example.HQL.ejemplo.repository.IEscuelaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscuelaServicio {

    private IEscuelaRepository escuelaRepository;

    public EscuelaServicio(IEscuelaRepository escuelaRepository) {
        this.escuelaRepository = escuelaRepository;
    }

    public Escuela buscarEscuelaPorDireccion(String direccion) {
        return escuelaRepository.findByDireccion(direccion).get();
    }

    public Escuela agregarEscuela(Escuela escuela) {
        return escuelaRepository.save(escuela);
    }

    public List<Escuela> listarEscuelas() {
        return escuelaRepository.findAll();
    }

}
