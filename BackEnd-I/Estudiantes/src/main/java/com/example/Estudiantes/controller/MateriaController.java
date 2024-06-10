package com.example.Estudiantes.controller;

import com.example.Estudiantes.entity.Materia;
import com.example.Estudiantes.entity.dto.MateriaDTO;
import com.example.Estudiantes.service.IMateriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    private IMateriaService materiaService;

    public MateriaController(IMateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public List<MateriaDTO> listarMaterias() {
        return materiaService.listarMaterias();
    }

    @GetMapping("/{id}")
    public MateriaDTO buscarMateriaPorId(@PathVariable Long id) {
        return materiaService.buscarMateriaPorId(id);
    }

    @PostMapping
    public ResponseEntity<?> agregarMateria(@RequestBody MateriaDTO materiaDTO) {
        materiaService.crearMateria(materiaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modificarMateria(@RequestBody MateriaDTO materiaDTO) {
        materiaService.modificarMateria(materiaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMateriaPorId(@PathVariable Long id) {
        materiaService.eliminarMateriaPorId(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
