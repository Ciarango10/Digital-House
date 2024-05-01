package ejemploclase.dh.backend.test;

import ejemploclase.dh.backend.model.Empleado;
import ejemploclase.dh.backend.model.EmpleadoContratado;
import ejemploclase.dh.backend.model.EmpleadoEfectivo;
import ejemploclase.dh.backend.service.Liquidador;
import ejemploclase.dh.backend.service.LiquidadorContratado;
import ejemploclase.dh.backend.service.LiquidadorEfectivo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorTest {

    @Test
    @DisplayName("Deberia emitir un documento en papel cuando es un empleado efectivo")
    void testEmpleadoEfectivo() {
        //dado
        Empleado empleado = new EmpleadoEfectivo("Martin", "Martini", "456711", 400, 40, 60 );
        Liquidador liquidador = new LiquidadorEfectivo();
        //cuando
        String respuestaObtenida = liquidador.liquidarSueldo(empleado);
        String respuestaEsperada = "La liquidacion generada es un documento impreso. Saldo a liquidar: 420.0";
        //entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @DisplayName("Debería emitir un documento digital cuando es un empleado contratado")
    void testEmpleadoContratado() {
        //dado
        Empleado empleado = new EmpleadoContratado("Pompilia", "Pompini,", "890123", 120, 7 );
        Liquidador liquidador = new LiquidadorContratado();
        //cuando
        String respuestaObtenida = liquidador.liquidarSueldo(empleado);
        String respuestaEsperada = "La liquidacion generada es un documento digital. Saldo a liquidar: 840.0";
        //entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @DisplayName("El liquidador debería arrojar un mensaje de error cuando no es posible calcular la liquidación.")
    void testEmpleadoIncorrecto() {
        //dado
        Empleado empleado = new EmpleadoContratado("Pompilia", "Pompini,", "890123", 120, 7 );
        Liquidador liquidador = new LiquidadorEfectivo();
        //cuando
        String respuestaObtenida = liquidador.liquidarSueldo(empleado);
        String respuestaEsperada = "La liquidacion no pudo ser calculada";
        //entonces
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

}