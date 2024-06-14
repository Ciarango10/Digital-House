package dh.backend.clinicamvc.service.impl;

import dh.backend.clinicamvc.dto.request.TurnoRequestDto;
import dh.backend.clinicamvc.dto.response.OdontologoResponseDto;
import dh.backend.clinicamvc.dto.response.PacienteResponseDto;
import dh.backend.clinicamvc.dto.response.TurnoResponseDto;
import dh.backend.clinicamvc.entity.Odontologo;
import dh.backend.clinicamvc.entity.Paciente;
import dh.backend.clinicamvc.entity.Turno;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;
import dh.backend.clinicamvc.repository.IOdontologoRepository;
import dh.backend.clinicamvc.repository.IPacienteRepository;
import dh.backend.clinicamvc.repository.ITurnoRepository;
import dh.backend.clinicamvc.service.ITurnoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);
    private IOdontologoRepository odontologoRepository;
    private IPacienteRepository pacienteRepository;
    private ITurnoRepository turnoRepository;
    private ModelMapper modelMapper;

    public TurnoService(IOdontologoRepository odontologoRepository, IPacienteRepository pacienteRepository, ITurnoRepository turnoRepository, ModelMapper modelMapper) {
        this.odontologoRepository = odontologoRepository;
        this.pacienteRepository = pacienteRepository;
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TurnoResponseDto registrarTurno(TurnoRequestDto turnoRequestDto) throws BadRequestException {
        Optional<Paciente> paciente = pacienteRepository.findById(turnoRequestDto.getPaciente_id());
        Optional<Odontologo> odontologo = odontologoRepository.findById(turnoRequestDto.getOdontologo_id());
        Turno turnoARegistrar = new Turno();
        Turno turnoGuardado = null;
        TurnoResponseDto turnoADevolver = null;
        if(paciente.isPresent() && odontologo.isPresent()) {
            turnoARegistrar.setPaciente(paciente.get());
            turnoARegistrar.setOdontologo(odontologo.get());
            turnoARegistrar.setFecha(LocalDate.parse(turnoRequestDto.getFecha()));
            turnoGuardado = turnoRepository.save(turnoARegistrar);

            turnoADevolver = mapToResponseDto(turnoGuardado);
            LOGGER.info("Turno persistido con exito");
            // Armar el turno a devolver
            /*PacienteResponseDto pacienteResponseDto = new PacienteResponseDto();
            pacienteResponseDto.setId(turnoGuardado.getPaciente().getId());
            pacienteResponseDto.setApellido(turnoGuardado.getPaciente().getApellido());
            pacienteResponseDto.setNombre(turnoGuardado.getPaciente().getNombre());
            pacienteResponseDto.setDNI(turnoGuardado.getPaciente().getDNI());

            OdontologoResponseDto odontologoResponseDto = new OdontologoResponseDto();
            odontologoResponseDto.setId(turnoGuardado.getOdontologo().getId());
            odontologoResponseDto.setApellido(turnoGuardado.getOdontologo().getApellido());
            odontologoResponseDto.setNombre(turnoGuardado.getOdontologo().getNombre());
            odontologoResponseDto.setNroMatricula(turnoGuardado.getOdontologo().getNroMatricula());

            turnoADevolver = new TurnoResponseDto();
            turnoADevolver.setId(turnoGuardado.getId());
            turnoADevolver.setOdontologo(odontologoResponseDto);
            turnoADevolver.setPaciente(pacienteResponseDto);
            turnoADevolver.setFecha(turnoGuardado.getFecha().toString());*/
        } else {
            throw new BadRequestException("{\"message\": \"El paciente u odontólogo no existen en la base de datos\"}");
        }

        return turnoADevolver;
    }

    @Override
    public TurnoResponseDto buscarPorId(Integer id) {
        Optional<Turno> turnoOptional = turnoRepository.findById(id);
        if(turnoOptional.isPresent()) {
            Turno turnoEncontrado = turnoOptional.get();
            TurnoResponseDto turnoADevolver = mapToResponseDto(turnoEncontrado);
            return turnoADevolver;
        }
        return null;
    }

    @Override
    public List<TurnoResponseDto> buscarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        List<TurnoResponseDto> turnosADevolver = new ArrayList<>();
        TurnoResponseDto turnoAuxiliar = null;
        for(Turno turno: turnos){
            turnoAuxiliar = mapToResponseDto(turno);
            turnosADevolver.add(turnoAuxiliar);
        }
        return turnosADevolver;
    }

    @Override
    public void actualizarTurno(Integer id, TurnoRequestDto turnoRequestDto) {
        Optional<Paciente> paciente = pacienteRepository.findById(turnoRequestDto.getPaciente_id());
        Optional<Odontologo> odontologo = odontologoRepository.findById(turnoRequestDto.getOdontologo_id());
        Optional<Turno> turno = turnoRepository.findById(id);
        Turno turnoAModificar = new Turno();
        if(paciente.isPresent() && odontologo.isPresent() && turno.isPresent()){
            turnoAModificar.setId(id);
            turnoAModificar.setOdontologo(odontologo.get());
            turnoAModificar.setPaciente(paciente.get());
            turnoAModificar.setFecha(LocalDate.parse(turnoRequestDto.getFecha()));
            turnoRepository.save(turnoAModificar);
            LOGGER.info("Turno modificado con exito");
        }
    }

    @Override
    public void eliminarTurno(Integer id) throws ResourceNotFoundException {
        TurnoResponseDto turnoResponseDto = buscarPorId(id);
        if(turnoResponseDto != null) {
            turnoRepository.deleteById(id);
            LOGGER.info("Turno eliminado con exito");
        } else {
            throw new ResourceNotFoundException("{\"message\": \"Turno no encontrado\"}");
        }
    }

    @Override
    public List<TurnoResponseDto> listarTurnosEntreFechas(LocalDate startDate, LocalDate endDate) {
        List<Turno> listadoTurnos = turnoRepository.buscarTurnosEntreFechas(startDate, endDate);
        List<TurnoResponseDto> listadoARetornar = new ArrayList<>();
        TurnoResponseDto turnoAuxiliar = null;

        for(Turno turno: listadoTurnos){
            turnoAuxiliar = mapToResponseDto(turno);
            listadoARetornar.add(turnoAuxiliar);
        }
        return listadoARetornar;
    }

    @Override
    public List<TurnoResponseDto> listarTurnosPosterioresFechaActual() {
        List<Turno> listadoTurnos = turnoRepository.buscarTurnosPosterioresFechaActual();
        List<TurnoResponseDto> listadoARetornar = new ArrayList<>();
        TurnoResponseDto turnoAuxiliar = null;

        for(Turno turno: listadoTurnos){
            turnoAuxiliar = mapToResponseDto(turno);
            listadoARetornar.add(turnoAuxiliar);
        }
        return listadoARetornar;
    }

    // Metodo que mapea Turno en TurnoResponseDto
    private TurnoResponseDto mapToResponseDto(Turno turno) {
        TurnoResponseDto turnoResponseDto = modelMapper.map(turno, TurnoResponseDto.class);
        turnoResponseDto.setOdontologo(modelMapper.map(turno.getOdontologo(), OdontologoResponseDto.class));
        turnoResponseDto.setPaciente(modelMapper.map(turno.getPaciente(), PacienteResponseDto.class));
        return turnoResponseDto;
    }
}
