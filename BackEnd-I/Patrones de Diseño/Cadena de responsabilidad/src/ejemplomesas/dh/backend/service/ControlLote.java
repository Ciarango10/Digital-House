package ejemplomesas.dh.backend.service;

import ejemplomesas.dh.backend.model.Articulo;

public class ControlLote extends ControlCalidad{

    @Override
    public String validarCalidaDelProducto(Articulo articulo) {
        if(articulo.getLote() >= 1000 && articulo.getLote() <= 2000) {
            return getSiguiente().validarCalidaDelProducto(articulo);
        } else {
            return "No cumple con el criterio de Lote. Rechazado";
        }
    }

}
