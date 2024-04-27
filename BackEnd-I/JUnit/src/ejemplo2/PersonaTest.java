package ejemplo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    @Test
    public void nombreCompleto() {
        Persona persona = new Persona("Carlos", "Arango", "carlosarango3101@gmail.com", 18);
        assertEquals("Carlos Arango", persona.nombreCompleto());
    }

    @Test
    public void esMayorEdad() {
        Persona persona = new Persona("Carlos", "Arango", "carlosarango3101@gmail.com", 18);
        assertTrue(persona.esMayorEdad());
    }
}