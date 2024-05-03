package ejemplomesas.dh.backend.test;

import ejemplomesas.dh.backend.model.Articulo;
import ejemplomesas.dh.backend.service.AnalistaCalidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlCalidadTest {

    @Test
    @DisplayName("Testear que falle el lote")
    void test1() {
        //dado
        Articulo articulo = new Articulo("Arroz", 2500, 1500, "sano");
        AnalistaCalidad analistaCalidad = new AnalistaCalidad();
        //cuando
        String respuesta = analistaCalidad.cadenaResponsabilidadCalidad(articulo);
        //entonces
        assertEquals("No cumple con el criterio de Lote. Rechazado", respuesta);
    }

    @Test
    @DisplayName("Testear que falle el peso")
    void test2() {
        //dado
        Articulo articulo = new Articulo("Arroz", 1200, 1500, "sano");
        AnalistaCalidad analistaCalidad = new AnalistaCalidad();
        //cuando
        String respuesta = analistaCalidad.cadenaResponsabilidadCalidad(articulo);
        //entonces
        assertEquals("No cumple con el criterio de Peso. Rechazado", respuesta);
    }

    @Test
    @DisplayName("Testear que falle el envase")
    void test3() {
        //dado
        Articulo articulo = new Articulo("Arroz", 1500, 1200, "defectuoso");
        AnalistaCalidad analistaCalidad = new AnalistaCalidad();
        //cuando
        String respuesta = analistaCalidad.cadenaResponsabilidadCalidad(articulo);
        //entonces
        assertEquals("No cumple con el criterio de Envasado. Rechazado", respuesta);
    }

    @Test
    @DisplayName("Testear que el producto sea aceptado")
    void test4() {
        //dado
        Articulo articulo = new Articulo("Arroz", 1500, 1200, "sano");
        AnalistaCalidad analistaCalidad = new AnalistaCalidad();
        //cuando
        String respuesta = analistaCalidad.cadenaResponsabilidadCalidad(articulo);
        //entonces
        assertEquals("Cumple con todos los criterios. Aceptado", respuesta);
    }

}