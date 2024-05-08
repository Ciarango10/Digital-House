package ejemplo.service;

import ejemplo.model.Direccion;
import ejemplo.model.Producto;
import ejemplo.model.Tarjeta;

import java.util.List;

public interface ICompraService {

    void procesarCompra(String productoId, Integer cantidad, Tarjeta tarjeta, Direccion direccion, List<Producto> productos);

}

