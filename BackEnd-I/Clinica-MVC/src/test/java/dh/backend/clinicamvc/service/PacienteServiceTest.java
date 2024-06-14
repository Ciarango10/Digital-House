package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.entity.Domicilio;
import dh.backend.clinicamvc.entity.Paciente;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.service.impl.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;
    private Paciente paciente;

    @BeforeEach
    void setUp() {
        paciente = new Paciente("Menganito", "Cosme", "46464646",
                LocalDate.of(2024,01,12),
                new Domicilio("Calle Falsa", 123, "San Pedro", "Jujuy"));
    }

    @Test
    @DisplayName("Testear que un paciente fue guardado")
    void testPacienteGuardado() throws BadRequestException {
        Paciente pacienteDesdeLaBD = pacienteService.registrarPaciente(paciente);

        assertNotNull(pacienteDesdeLaBD);
    }

    @Test
    @DisplayName("Testear busqueda paciente por id")
    void testPacientePorId(){
        Integer id = 1;
        Optional<Paciente> pacienteEncontrado = pacienteService.buscarPorId(id);
        Paciente paciente = pacienteEncontrado.get();

        assertEquals(id, paciente.getId());
    }

    @Test
    @DisplayName("Testear busqueda todos los pacientes")
    void testBusquedaTodos(){
        List<Paciente> pacientes = pacienteService.buscarTodos();

        assertTrue(pacientes.size() > 0);
    }

}