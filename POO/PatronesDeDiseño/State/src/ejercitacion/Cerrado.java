package ejercitacion;

public class Cerrado implements StateCarrito{
    private Carrito c;

    public Cerrado(Carrito c) {
        this.c = c;
    }

    @Override
    public void agregarProducto(Producto producto) {
        System.out.println("No puede agregar mas productos porque su pedido ya se cerró");
    }

    @Override
    public void cancelar() {
        c.getProductos().clear();
        c.setEstado(new Vacio(c));
    }

    @Override
    public void volver() {
        System.out.println("No puede volver al punto anterior porque su pedido ya se cerró");
    }

    @Override
    public void siguienteEstado() {
        c.getProductos().clear();
        c.setEstado(new Vacio(c));
    }
}
