package dh.backend.clinicamvc.controller;

import dh.backend.clinicamvc.entity.Especialidad;
import dh.backend.clinicamvc.entity.Odontologo;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;
import dh.backend.clinicamvc.service.IEspecialidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    private IEspecialidadService especialidadService;

    public EspecialidadController(IEspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping
    public ResponseEntity<List<Especialidad>> listarEspecialidades() {
        return ResponseEntity.ok(especialidadService.buscarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> buscarEspecialidad(@PathVariable Integer id) throws ResourceNotFoundException {
        Optional<Especialidad> especialidad = especialidadService.buscarPorId(id);
        return ResponseEntity.ok(especialidad.get());
    }

    @PostMapping
    public ResponseEntity<Especialidad> agregarEspecialidad(@RequestBody Especialidad especialidad) throws BadRequestException {
        return ResponseEntity.ok(especialidadService.registrarEspecialidad(especialidad));
    }

}
