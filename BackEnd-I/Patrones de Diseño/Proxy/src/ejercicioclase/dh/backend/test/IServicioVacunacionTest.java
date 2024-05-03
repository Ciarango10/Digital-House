package ejercicioclase.dh.backend.test;

import ejercicio2.DocumentoService;
import ejercicioclase.dh.backend.model.Persona;
import ejercicioclase.dh.backend.service.IServicioVacunacion;
import ejercicioclase.dh.backend.service.ProxyVacunacion;
import ejercicioclase.dh.backend.service.Vacunacion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class IServicioVacunacionTest {

    @Test
    @DisplayName("La persona se puede vacunar")
    void test1() {
        //dado
        Persona persona = new Persona("Carlos", "Arango", "102536147", LocalDate.of(2024,04,15), "Antigripal");
        IServicioVacunacion proxy = new ProxyVacunacion(new Vacunacion());
        //cuando
        String respuesta = proxy.vacunar(persona);
        //entonces
        assertEquals("La persona: Carlos Arango se vacunó con: Antigripal", respuesta);
    }

    @Test
    @DisplayName("La persona no se puede vacunar")
    void test2() {
        //dado
        Persona persona = new Persona("Carlos", "Arango", "102536147", LocalDate.of(2024,05,10), "Antigripal");
        IServicioVacunacion proxy = new ProxyVacunacion(new Vacunacion());
        //cuando
        String respuesta = proxy.vacunar(persona);
        //entonces
        assertEquals("La persona no cumple con los requisitos", respuesta);
    }

}