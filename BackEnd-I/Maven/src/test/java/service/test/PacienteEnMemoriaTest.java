package service.test;
import dh.backend.dao.impl.PacienteEnMemoria;
import dh.backend.model.Domicilio;
import dh.backend.model.Paciente;
import dh.backend.service.PacienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class PacienteEnMemoriaTest {
    private static PacienteService pacienteService = new PacienteService(new PacienteEnMemoria());

    @Test
    @DisplayName("Testear que un paciente fue guardado")
    void testPacienteGuardado(){
        Paciente paciente = new Paciente("Cosme","Menganito","456464", LocalDate.of(2024,4,22),
                new Domicilio("Calle Falsa", 456, "Springfield","Montana"));
        Paciente pacienteDesdeMemoria= pacienteService.registrarPaciente(paciente);

        assertNotNull(pacienteDesdeMemoria);
    }

    @Test
    @DisplayName("Testear busqueda paciente por id")
    void testPacientePorId(){
        Paciente paciente = new Paciente("Cosme","Menganito","456464", LocalDate.of(2024,4,22),
                new Domicilio("Calle Falsa", 456, "Springfield","Montana"));
        pacienteService.registrarPaciente(paciente);

        Integer id = 1;
        Paciente pacienteEncontrado = pacienteService.buscarPorId(id);

        assertEquals(id, pacienteEncontrado.getId());
    }

    @Test
    @DisplayName("Testear busqueda todos los pacientes")
    void testBusquedaTodos(){
        List<Paciente> pacientes = pacienteService.buscarTodos();

        assertEquals(1, pacientes.size());
    }
}
