package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.dto.request.TurnoRequestDto;
import dh.backend.clinicamvc.dto.response.TurnoResponseDto;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {
    TurnoResponseDto registrarTurno(TurnoRequestDto turnoRequestDto) throws BadRequestException;

    TurnoResponseDto buscarPorId(Integer id);

    List<TurnoResponseDto> buscarTodos();

    void actualizarTurno(Integer id, TurnoRequestDto turno);

    void eliminarTurno(Integer id) throws ResourceNotFoundException;

    List<TurnoResponseDto> listarTurnosEntreFechas(LocalDate startDate, LocalDate endDate);

    List<TurnoResponseDto> listarTurnosPosterioresFechaActual();
}
