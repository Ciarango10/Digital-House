package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    Odontologo registrarOdontologo(Odontologo odontologo);

    Optional<Odontologo> buscarPorId(Integer id);

    List<Odontologo> buscarTodos();

    void actualizarOdontologo(Odontologo odontologo);

    void eliminarOdontologo(Integer id);

    List<Odontologo> buscarOdontologoPorApellido(String apellido);

    List<Odontologo> buscarOdontologoPorNombre(String nombre);
}
