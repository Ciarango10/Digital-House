package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.model.Odontologo;
import dh.backend.clinicamvc.model.Paciente;

import java.util.List;

public interface IOdontologoService {
    Odontologo registrarOdontologo(Odontologo odontologo);

    Odontologo buscarPorId(Integer id);

    List<Odontologo> buscarTodos();
}
