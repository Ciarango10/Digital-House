package dh.backend.clinicamvc.controller;

import dh.backend.clinicamvc.dto.request.TurnoRequestDto;
import dh.backend.clinicamvc.dto.response.TurnoResponseDto;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;
import dh.backend.clinicamvc.service.ITurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public ResponseEntity<List<TurnoResponseDto>> buscarTodos() {
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoResponseDto> buscarTurnoPorId(@PathVariable Integer id) {
        TurnoResponseDto turno = turnoService.buscarPorId(id);
        if(turno != null) {
            return ResponseEntity.ok(turno);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @GetMapping("/fechas")
    public ResponseEntity<List<TurnoResponseDto>> buscarTurnosEntreFechas(@RequestParam String inicio, @RequestParam String fin) {
        LocalDate fechaInicio = LocalDate.parse(inicio, formatter);
        LocalDate fechaFin = LocalDate.parse(fin, formatter);

        return ResponseEntity.ok(turnoService.listarTurnosEntreFechas(fechaInicio, fechaFin));
    }

    @GetMapping("/posteriorFechaActual")
    public ResponseEntity<List<TurnoResponseDto>> buscarTurnosPosterioresFechaActual() {
        return ResponseEntity.ok(turnoService.listarTurnosPosterioresFechaActual());
    }

    @PostMapping
    public ResponseEntity<TurnoResponseDto> registrarTurno(@RequestBody TurnoRequestDto turno) throws BadRequestException {
        TurnoResponseDto turnoADevolver = turnoService.registrarTurno(turno);
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoADevolver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarTurno(@PathVariable Integer id, @RequestBody TurnoRequestDto turno) {
        TurnoResponseDto turnoResponseDto = turnoService.buscarPorId(id);
        if(turnoResponseDto != null) {
            turnoService.actualizarTurno(id, turno);
            return ResponseEntity.ok("{\"message\": \"Turno modificado\"}");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("{\"message\": \"Turno eliminado\"}");
    }

}
