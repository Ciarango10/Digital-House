package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.dao.impl.PacienteDaoH2;
import dh.backend.clinicamvc.model.Domicilio;
import dh.backend.clinicamvc.model.Paciente;
import dh.backend.clinicamvc.service.impl.PacienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    private static PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @Test
    @DisplayName("Testear que un paciente fue guardado")
    void testPacienteGuardado(){
        Paciente paciente = new Paciente("Carlos","Menganito","456464", LocalDate.of(2024,4,22),
                new Domicilio("Calle Falsa", 456, "Springfield","Montana"));
        Paciente pacienteDesdeLaBD = pacienteService.registrarPaciente(paciente);

        assertNotNull(pacienteDesdeLaBD);
    }

    @Test
    @DisplayName("Testear busqueda paciente por id")
    void testPacientePorId(){
        Integer id = 1;
        Paciente pacienteEncontrado = pacienteService.buscarPorId(id);

        assertEquals(id, pacienteEncontrado.getId());
    }

    @Test
    @DisplayName("Testear busqueda todos los pacientes")
    void testBusquedaTodos(){
        List<Paciente> pacientes = pacienteService.buscarTodos();

        assertTrue(pacientes.size() > 0);
    }

}