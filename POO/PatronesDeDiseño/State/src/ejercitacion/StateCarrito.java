package ejercitacion;

public interface StateCarrito {
    void agregarProducto(Producto producto);
    void cancelar();
    void volver();
    void siguienteEstado();
}
