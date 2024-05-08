package ejemplomesas.dh.backend.test;

import ejemplomesas.dh.backend.model.Hotel;
import ejemplomesas.dh.backend.model.Vuelo;
import ejemplomesas.dh.backend.service.FacadeServicio;
import ejemplomesas.dh.backend.service.IFacadeServicio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class IFacadeServicioTest {

    @Test
    @DisplayName("Testear que exista el servicio")
    void existeServicio() {

        IFacadeServicio facadeServicio = new FacadeServicio();
        boolean respuesta = facadeServicio.buscarServicio("Buenos Aires", "Los Angeles", LocalDate.of(2024,06,15), LocalDate.of(2024,06,20));
        assertTrue(respuesta);
    }

}