package ejerciciomesas.dh.backend.test;

import ejerciciomesas.dh.backend.model.Arbol;
import ejerciciomesas.dh.backend.service.ArbolFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolFactoryTest {

    @Test
    @DisplayName("Validar dos Instancias")
    void testDosInstancias() {
        for (int i = 0; i < 500000; i++) {
            Arbol arbol = ArbolFactory.plantarArboles("Frutales");
            Arbol arbol2 = ArbolFactory.plantarArboles("Ornamentales");
        }

        assertEquals(2, Arbol.getContador());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }

}