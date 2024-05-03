package ejemplomesas.dh.backend.service;

import ejemplomesas.dh.backend.model.Articulo;

public abstract class ControlCalidad {

    private ControlCalidad siguiente;
    public abstract String validarCalidaDelProducto(Articulo articulo);

    public ControlCalidad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ControlCalidad siguiente) {
        this.siguiente = siguiente;
    }

}
