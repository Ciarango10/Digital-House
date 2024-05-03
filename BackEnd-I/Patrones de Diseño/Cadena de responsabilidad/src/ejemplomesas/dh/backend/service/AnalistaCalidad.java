package ejemplomesas.dh.backend.service;

import ejemploclase.dh.backend.service.*;
import ejemplomesas.dh.backend.model.Articulo;

public class AnalistaCalidad {

    public String cadenaResponsabilidadCalidad(Articulo articulo) {
        ControlCalidad control1 = new ControlLote();
        ControlCalidad control2 = new ControlPeso();
        ControlCalidad control3 = new ControlEnvase();

        control1.setSiguiente(control2);
        control2.setSiguiente(control3);

        return control1.validarCalidaDelProducto(articulo);
    }

}
