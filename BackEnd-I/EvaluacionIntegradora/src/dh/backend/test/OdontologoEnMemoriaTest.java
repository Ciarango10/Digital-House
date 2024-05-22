package dh.backend.test;

import dh.backend.dao.IDao;
import dh.backend.dao.impl.OdontologoDAOEnMemoria;
import dh.backend.dao.impl.OdontologoDAOH2;
import dh.backend.model.Odontologo;
import dh.backend.service.OdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoEnMemoriaTest {

    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDAOEnMemoria());

    @Test
    public void testGuardarYListarOdontologos() {
        // Guardar algunos odontólogos
        Odontologo odontologo1 = new Odontologo(12345, "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(67890, "Ana", "Gomez");

        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);

        // Listar todos los odontólogos
        List<Odontologo> odontologos = odontologoService.listarTodos();
        // Verificar que la lista no sea nula y tenga dos elementos
        assertNotNull(odontologos);
        assertEquals(2, odontologos.size());
    }

}