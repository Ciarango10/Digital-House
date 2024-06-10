package com.example.Estudiantes.controller;

import com.example.Estudiantes.entity.Cursada;
import com.example.Estudiantes.entity.dto.CursadaDTO;
import com.example.Estudiantes.entity.dto.MateriaDTO;
import com.example.Estudiantes.service.ICursadaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursadas")
public class CursadaController {

    private ICursadaService cursadaService;

    public CursadaController(ICursadaService cursadaService) {
        this.cursadaService = cursadaService;
    }

    @GetMapping
    public List<CursadaDTO> listarCursadas() {
        return cursadaService.listarCursadas();
    }

    @GetMapping("/{id}")
    public CursadaDTO buscarCursadaPorId(@PathVariable Long id) {
        return cursadaService.buscarCursadaPorId(id);
    }

    @PostMapping
    public ResponseEntity<?> agregarCursada(@RequestBody CursadaDTO cursadaDTO) {
        cursadaService.crearCursada(cursadaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modificarCursada(@RequestBody CursadaDTO cursadaDTO) {
        cursadaService.modificarCursada(cursadaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCursadaPorId(@PathVariable Long id) {
        cursadaService.eliminarCursadaPorId(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
