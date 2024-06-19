package dh.backend.clinicamvc.service.impl;

import dh.backend.clinicamvc.entity.Especialidad;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;
import dh.backend.clinicamvc.repository.IEspecialidadRepository;
import dh.backend.clinicamvc.service.IEspecialidadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService implements IEspecialidadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EspecialidadService.class);

    private IEspecialidadRepository especialidadRepository;

    public EspecialidadService(IEspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public Especialidad registrarEspecialidad(Especialidad especialidad) throws BadRequestException {
        LOGGER.info("Especialidad persistido con exito");
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Optional<Especialidad> buscarPorId(Integer id) throws ResourceNotFoundException {
        Optional<Especialidad> especialidadOptional = especialidadRepository.findById(id);
        if(especialidadOptional.isEmpty()) {
            throw new ResourceNotFoundException("{\"message\": \"Especialidad no encontrada\"}");
        }
        return especialidadOptional;
    }

    @Override
    public List<Especialidad> buscarTodas() {
        return especialidadRepository.findAll();
    }
}
