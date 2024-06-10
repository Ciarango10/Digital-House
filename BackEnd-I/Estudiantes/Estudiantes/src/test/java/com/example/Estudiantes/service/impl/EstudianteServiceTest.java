package com.example.Estudiantes.service.impl;

import com.example.Estudiantes.entity.dto.EstudianteDTO;
import com.example.Estudiantes.service.IEstudianteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EstudianteServiceTest {

    @Autowired
    private IEstudianteService estudianteService;

    @Test
    public void testCrearEstudiante() {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setNombre("Javier");
        estudianteDTO.setApellido("Rebuch");
        estudianteService.crearEstudiante(estudianteDTO);

        EstudianteDTO estudianteJavier = estudianteService.buscarEstudiantePorId(1L);

        assertTrue(estudianteJavier != null);
    }

}