package ejemploclase.dh.backend.test;

import ejemploclase.dh.backend.model.Computadora;
import ejemploclase.dh.backend.service.ComputadoraFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputadoraFactoryTest {

    @Test
    @DisplayName("Testear que solo se crea una instancia de windows")
    void testUnaInstancia() {
        Computadora computadora1 = ComputadoraFactory.obtenerComputadora("Windows");
        Computadora computadora2 = ComputadoraFactory.obtenerComputadora("Windows");
        Computadora computadora3 = ComputadoraFactory.obtenerComputadora("Windows");
        Computadora computadora4 = ComputadoraFactory.obtenerComputadora("Windows");

        assertEquals(1, Computadora.getContador());
    }

    @Test
    @DisplayName("Testear que se creen dos instancias de computadoras")
    void testDosInstancia(){
        Computadora computadora1 = ComputadoraFactory.obtenerComputadora("Windows");
        Computadora computadora2 = ComputadoraFactory.obtenerComputadora("Mac16");
        Computadora computadora3 = ComputadoraFactory.obtenerComputadora("Windows");
        Computadora computadora4 = ComputadoraFactory.obtenerComputadora("Mac16");

        assertEquals(2,Computadora.getContador());
    }


}