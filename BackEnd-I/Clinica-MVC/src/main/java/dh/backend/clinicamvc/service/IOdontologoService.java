package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.entity.Odontologo;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    Odontologo registrarOdontologo(Odontologo odontologo) throws BadRequestException;

    Optional<Odontologo> buscarPorId(Integer id);

    List<Odontologo> buscarTodos();

    void actualizarOdontologo(Odontologo odontologo);

    void eliminarOdontologo(Integer id) throws ResourceNotFoundException;

    List<Odontologo> buscarOdontologoPorApellido(String apellido);

    List<Odontologo> buscarOdontologoPorNombre(String nombre);
}
