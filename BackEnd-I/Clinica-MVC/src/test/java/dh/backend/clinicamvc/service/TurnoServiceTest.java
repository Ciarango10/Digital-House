package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.dto.request.TurnoRequestDto;
import dh.backend.clinicamvc.dto.response.TurnoResponseDto;
import dh.backend.clinicamvc.entity.Domicilio;
import dh.backend.clinicamvc.entity.Odontologo;
import dh.backend.clinicamvc.entity.Paciente;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.service.impl.OdontologoService;
import dh.backend.clinicamvc.service.impl.PacienteService;
import dh.backend.clinicamvc.service.impl.TurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;
    private TurnoRequestDto turno;
    private Odontologo odontologo;
    private Paciente paciente;

    @BeforeEach
    void setUp() throws BadRequestException {
        Paciente pacientePrueba = new Paciente("Menganito", "Cosme", "46464646",
                LocalDate.of(2024,01,12),
                new Domicilio("Calle Falsa", 123, "San Pedro", "Jujuy"));
        paciente = pacienteService.registrarPaciente(pacientePrueba);

        Odontologo odontologoPrueba = new Odontologo(1234, "Juan", "Herrera");
        odontologo = odontologoService.registrarOdontologo(odontologoPrueba);

        turno = new TurnoRequestDto(paciente.getId(), odontologo.getId(), "2024-01-12");
    }

    @Test
    @DisplayName("Testear que un turno fue guardado")
    void testTurnoGuardado() throws BadRequestException {

        TurnoResponseDto turnoDesdeLaDB = turnoService.registrarTurno(turno);

        assertNotNull(turnoDesdeLaDB);
    }

    @Test
    @DisplayName("Testear busqueda turno por id")
    void testTurnoPorId(){
        Integer id = 3;
        TurnoResponseDto turnoEncontrado = turnoService.buscarPorId(id);

        assertNotNull(turnoEncontrado);
    }

    @Test
    @DisplayName("Testear busqueda todos los turnos")
    void testBusquedaTodos(){
        List<TurnoResponseDto> turnos = turnoService.buscarTodos();

        assertTrue(turnos.size() > 0);
    }
}