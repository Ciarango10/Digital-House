package ejemploclase.dh.backend.service;

import ejemploclase.dh.backend.model.Producto;
import ejemploclase.dh.backend.model.Tarjeta;

public interface IFacadeDescuento {

    int calculoDescuento(Producto producto, Tarjeta tarjeta, int cantidad);

}
