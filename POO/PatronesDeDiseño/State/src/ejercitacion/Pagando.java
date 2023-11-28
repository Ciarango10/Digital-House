package ejercitacion;

public class Pagando implements StateCarrito{
    private Carrito c;

    public Pagando(Carrito c) {
        this.c = c;
    }

    @Override
    public void agregarProducto(Producto producto) {
        System.out.println("No puede agregar mas productos porque esta en proceso de pago");
    }

    @Override
    public void cancelar() {
        c.getProductos().clear();
        c.setEstado(new Vacio(c));
    }

    @Override
    public void volver() {
        c.setEstado(new Cargando(c));
    }

    @Override
    public void siguienteEstado() {
        c.setEstado(new Cerrado(c));
    }
}
