package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.dto.request.TurnoRequestDto;
import dh.backend.clinicamvc.dto.response.TurnoResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {
    TurnoResponseDto registrarTurno(TurnoRequestDto turnoRequestDto);

    TurnoResponseDto buscarPorId(Integer id);

    List<TurnoResponseDto> buscarTodos();

    void actualizarTurno(Integer id, TurnoRequestDto turno);

    void eliminarTurno(Integer id);

    List<TurnoResponseDto> listarTurnosEntreFechas(LocalDate startDate, LocalDate endDate);

    List<TurnoResponseDto> listarTurnosPosterioresFechaActual();
}
