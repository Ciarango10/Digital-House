package ejemplomesas.dh.backend.service;

import ejemplomesas.dh.backend.model.Menu;

public abstract class ArmadoMenu {
    public String prepararMenu(Menu menu) {
        String respuesta = null;
        //Paso 1
        String armado = armarMenu(menu);
        //Paso 2
        double precio = calcularPrecioVenta(menu);
        respuesta = "El menu se prepara: "+armado+" y tiene un costo de: "+precio;
        return respuesta;
    }

    public abstract String armarMenu(Menu menu);
    public abstract double calcularPrecioVenta(Menu menu);
}
