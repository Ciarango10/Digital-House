package ejercitacion;

import ejemplo.Auto;

public class Vacio implements StateCarrito{

    private Carrito c;

    public Vacio(Carrito c) {
        this.c = c;
    }

    @Override
    public void agregarProducto(Producto producto) {
        c.getProductos().add(producto);
        c.setEstado(new Cargando(c));
    }

    @Override
    public void cancelar() {
        System.out.println("El carrito ya está vacio");
    }

    @Override
    public void volver() {
        System.out.println("El carrito está vacio, agregue un producto");
    }

    @Override
    public void siguienteEstado() {
        c.setEstado(new Cargando(c));
    }
}
