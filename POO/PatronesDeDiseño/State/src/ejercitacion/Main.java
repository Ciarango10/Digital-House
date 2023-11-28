package ejercitacion;

public class Main {
    public static void main(String[] args) {
        Carrito carrito = new Carrito();
        Producto producto = new Producto(10000.00, "Cepillo de dientes");
        Producto producto2 = new Producto(450000.00, "Control de PS5");


        //Vacio
        carrito.cancelar();
        carrito.volver();
        carrito.agregarProducto(producto);
        System.out.println(carrito.getProductos());

        //Cargando
        carrito.agregarProducto(producto2);
        System.out.println(carrito.getProductos());
        carrito.siguienteEstado();

        //Pagando
        carrito.agregarProducto(producto);
        carrito.siguienteEstado();

        //Cerrado
        carrito.agregarProducto(producto);
        carrito.volver();
        carrito.siguienteEstado();

        //Vacio nuevamente
        carrito.cancelar();
    }
}
