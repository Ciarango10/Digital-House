package ejemplomesas.dh.backend.service;

import ejemplomesas.dh.backend.model.Articulo;

public class ControlPeso extends ControlCalidad{

    @Override
    public String validarCalidaDelProducto(Articulo articulo) {
        if(articulo.getPeso() >= 1200 && articulo.getPeso() <= 1300) {
            return getSiguiente().validarCalidaDelProducto(articulo);
        } else {
            return "No cumple con el criterio de Peso. Rechazado";
        }
    }

}
