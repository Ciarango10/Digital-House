package dh.backend.clinicamvc.service.impl;


import dh.backend.clinicamvc.entity.Paciente;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;
import dh.backend.clinicamvc.repository.IPacienteRepository;
import dh.backend.clinicamvc.service.IPacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);
    private IPacienteRepository pacienteRepository;

    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente registrarPaciente(Paciente paciente) throws BadRequestException {
        if(paciente.getNombre() == null || paciente.getApellido() == null)
            throw new BadRequestException("{\"message\": \"Error al crear el Paciente\"}");

        LOGGER.info("Paciente persistido con exito");
        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> buscarPorId(Integer id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
        LOGGER.info("Paciente modificado con exito");
    }

    @Override
    public void eliminarPaciente(Integer id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteOptional = buscarPorId(id);
        if(pacienteOptional.isPresent()) {
            pacienteRepository.deleteById(id);
            LOGGER.info("Paciente eliminado con exito");
        } else {
            throw new ResourceNotFoundException("{\"message\": \"Paciente no encontrado\"}");
        }
    }

    @Override
    public Paciente buscarPacientePorDNI(String dni) {
        return pacienteRepository.findByDNI(dni);
    }

    @Override
    public List<Paciente> buscarPacientesPorProvincia(String provincia) {
        return pacienteRepository.findByProvincia(provincia);
    }

}
