package ejemploclase.dh.backend.service;

import ejemploclase.dh.backend.model.Producto;
import ejemploclase.dh.backend.model.Tarjeta;

public class ApiProducto {

    public int descuento(Producto producto) {
        int descuento = 0;
        if(producto.getTipo().equals("latas")) {
            descuento = 10;
        }
        return descuento;
    }

}
