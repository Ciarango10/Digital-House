package ejemploclase.dh.backend.service;

import ejemploclase.dh.backend.model.Producto;
import ejemploclase.dh.backend.model.Tarjeta;

public class FacadeDescuento implements IFacadeDescuento{

    ApiCantidad apiCantidad;
    ApiTarjeta apiTarjeta;
    ApiProducto apiProducto;

    public FacadeDescuento() {
        apiCantidad = new ApiCantidad();
        apiTarjeta = new ApiTarjeta();
        apiProducto = new ApiProducto();
    }

    @Override
    public int calculoDescuento(Producto producto, Tarjeta tarjeta, int cantidad) {
        int sumaDescuentos = 0;
        sumaDescuentos += apiCantidad.descuento(cantidad);
        sumaDescuentos += apiProducto.descuento(producto);
        sumaDescuentos += apiTarjeta.descuento(tarjeta);
        return sumaDescuentos;
    }

}
