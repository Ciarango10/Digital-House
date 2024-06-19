package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.entity.Especialidad;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IEspecialidadService {
    Especialidad registrarEspecialidad(Especialidad especialidad) throws BadRequestException;

    Optional<Especialidad> buscarPorId(Integer id) throws ResourceNotFoundException;

    List<Especialidad> buscarTodas();
}
