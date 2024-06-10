package com.example.Estudiantes.controller;

import com.example.Estudiantes.entity.Estudiante;
import com.example.Estudiantes.entity.dto.EstudianteDTO;
import com.example.Estudiantes.service.IEstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private IEstudianteService estudianteService;

    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<EstudianteDTO> listarEstudiantes() {
        return estudianteService.listarEstudiantes();
    }

    @GetMapping("/{id}")
    public EstudianteDTO buscarEstudiantePorId(@PathVariable Long id) {
        return estudianteService.buscarEstudiantePorId(id);
    }

    @PostMapping
    public ResponseEntity<?> agregarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        estudianteService.crearEstudiante(estudianteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modificarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        estudianteService.modificarEstudiante(estudianteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstudiantePorId(@PathVariable Long id) {
        estudianteService.eliminarEstudiantePorId(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
