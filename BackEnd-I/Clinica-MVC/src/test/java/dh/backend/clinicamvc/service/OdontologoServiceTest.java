package dh.backend.clinicamvc.service;

import dh.backend.clinicamvc.dao.impl.OdontologoDaoH2;
import dh.backend.clinicamvc.model.Odontologo;
import dh.backend.clinicamvc.service.impl.OdontologoService;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    public void testGuardarYListarOdontologos()  {
        Odontologo odontologo = new Odontologo(1234, "Juan", "Herrera");
        odontologoService.registrarOdontologo(odontologo);

        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertTrue(odontologos.size() > 0);
    }

}