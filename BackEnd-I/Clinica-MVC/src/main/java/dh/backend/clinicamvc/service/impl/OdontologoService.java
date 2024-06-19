package dh.backend.clinicamvc.service.impl;

import dh.backend.clinicamvc.entity.Especialidad;
import dh.backend.clinicamvc.entity.Odontologo;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;
import dh.backend.clinicamvc.repository.IOdontologoRepository;
import dh.backend.clinicamvc.service.IEspecialidadService;
import dh.backend.clinicamvc.service.IOdontologoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);
    private IOdontologoRepository odontologoRepository;
    //Otra forma de hacerlo
    private IEspecialidadService especialidadService;

    public OdontologoService(IOdontologoRepository odontologoRepository, IEspecialidadService especialidadService) {
        this.odontologoRepository = odontologoRepository;
        this.especialidadService = especialidadService;
    }

    @Override
    public Odontologo registrarOdontologo(Odontologo odontologo) throws BadRequestException {
        if(odontologo.getNombre() == null || odontologo.getApellido() == null)
            throw new BadRequestException("{\"message\": \"Error al crear el Odontólogo\"}");

        LOGGER.info("Odontólogo persistido con exito");
        return odontologoRepository.save(odontologo);
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> buscarPorId(Integer id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public void actualizarOdontologo(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
        LOGGER.info("Odontólogo modificado con exito");
    }

    @Override
    public void eliminarOdontologo(Integer id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoOptional = buscarPorId(id);
        if (odontologoOptional.isPresent()) {
            odontologoRepository.deleteById(id);
            LOGGER.info("Odontólogo eliminado con exito");
        } else {
            throw new ResourceNotFoundException("{\"message\": \"Odontólogo no encontrado\"}");
        }
    }

    @Override
    public List<Odontologo> buscarOdontologoPorApellido(String apellido) {
        return odontologoRepository.findByApellido(apellido);
    }

    @Override
    public List<Odontologo> buscarOdontologoPorNombre(String nombre) {
        return odontologoRepository.findByNombreLike(nombre);
    }

    @Override
    public Odontologo agregarEspecialidad(Integer id_odontologo, Integer id_especialidad) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoOptional = odontologoRepository.findById(id_odontologo);
        if(odontologoOptional.isEmpty()) {
            throw new ResourceNotFoundException("{\"message\": \"Odontólogo no encontrado\"}");
        }
        Optional<Especialidad> especialidadOptional = especialidadService.buscarPorId(id_especialidad);
        if(especialidadOptional.isEmpty()) {
            throw new ResourceNotFoundException("{\"message\": \"Especialidad no encontrada\"}");
        }

        Odontologo odontologo = odontologoOptional.get();
        odontologo.getEspecialidades().add(especialidadOptional.get());
        actualizarOdontologo(odontologo);

        return odontologo;
    }

}
