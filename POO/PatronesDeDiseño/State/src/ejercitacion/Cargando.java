package ejercitacion;

public class Cargando implements StateCarrito{
    private Carrito c;

    public Cargando(Carrito c) {
        this.c = c;
    }

    @Override
    public void agregarProducto(Producto producto) {
        c.getProductos().add(producto);
    }

    @Override
    public void cancelar() {
        c.getProductos().clear();
        c.setEstado(new Vacio(c));
    }

    @Override
    public void volver() {
        c.getProductos().clear();
        c.setEstado(new Vacio(c));
    }

    @Override
    public void siguienteEstado() {
        c.setEstado(new Pagando(c));
    }
}
