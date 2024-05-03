package ejemplomesas.dh.backend.service;

import ejemplomesas.dh.backend.model.Articulo;

public class ControlEnvase extends ControlCalidad{

    @Override
    public String validarCalidaDelProducto(Articulo articulo) {
        if(articulo.getEnvasado().equalsIgnoreCase("sano") || articulo.getEnvasado().equalsIgnoreCase("casi sano")) {
            return "Cumple con todos los criterios. Aceptado";
        } else {
            return "No cumple con el criterio de Envasado. Rechazado";
        }
    }

}
