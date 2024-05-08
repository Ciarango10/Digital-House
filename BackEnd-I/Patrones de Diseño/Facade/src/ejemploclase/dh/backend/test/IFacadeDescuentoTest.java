package ejemploclase.dh.backend.test;

import ejemploclase.dh.backend.model.Producto;
import ejemploclase.dh.backend.model.Tarjeta;
import ejemploclase.dh.backend.service.FacadeDescuento;
import ejemploclase.dh.backend.service.IFacadeDescuento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IFacadeDescuentoTest {

    @Test
    @DisplayName("Testear que sumamos todos los descuentos")
    void testTodosDescuentos() {
        Tarjeta tarjeta = new Tarjeta("128903123", "Star Bank");
        Producto producto = new Producto("Latas de arbejas", "latas");
        int cantidad = 19;

        IFacadeDescuento facadeDescuento = new FacadeDescuento();
        int descuentoObtenido = facadeDescuento.calculoDescuento(producto, tarjeta, cantidad);

        assertEquals(45, descuentoObtenido);
    }

    @Test
    @DisplayName("Testear que solo obtuvimos el descuento de producto")
    void testDescuentoProducto() {
        Tarjeta tarjeta = new Tarjeta("128903123", "Santander");
        Producto producto = new Producto("Latas de arbejas", "latas");
        int cantidad = 5;

        IFacadeDescuento facadeDescuento = new FacadeDescuento();
        int descuentoObtenido = facadeDescuento.calculoDescuento(producto, tarjeta, cantidad);

        assertEquals(10, descuentoObtenido);
    }

    @Test
    @DisplayName("Testear que solo obtuvimos el descuento de cantidad")
    void testDescuentoCantidad() {
        Tarjeta tarjeta = new Tarjeta("128903123", "Santander");
        Producto producto = new Producto("Air force 1", "zapatos");
        int cantidad = 15;

        IFacadeDescuento facadeDescuento = new FacadeDescuento();
        int descuentoObtenido = facadeDescuento.calculoDescuento(producto, tarjeta, cantidad);

        assertEquals(15, descuentoObtenido);
    }

}