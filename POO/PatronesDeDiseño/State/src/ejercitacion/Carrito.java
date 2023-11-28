package ejercitacion;

import ejemplo.Apagado;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private StateCarrito estado;
    private List<Producto> productos;

    public Carrito() {
        this.setEstado(new Vacio(this));
        this.productos = new ArrayList<>();
    }

    public StateCarrito getEstado() {
        return estado;
    }
    public List<Producto> getProductos() {
        return productos;
    }
    public void setEstado(StateCarrito estado) {
        this.estado = estado;
    }

    void agregarProducto(Producto producto) {
        getEstado().agregarProducto(producto);
    }
    void cancelar(){
        getEstado().cancelar();
    }
    void volver() {
        getEstado().volver();
    }
    void siguienteEstado(){
        getEstado().siguienteEstado();
    }

}
