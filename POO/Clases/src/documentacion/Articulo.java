package documentacion;

public class Articulo {
    // DEFINIMOS LOS ATRIBUTOS
    private String descripcion;
    private double precioVenta;
    private int stock;
    private static String moneda; // VARIABLE DE CLASE, SE DEFINE STATIC PARA QUE NO SE PUEDA USAR COMO UN OBJETO

    // GETTERS
    public String getDescripcion () {
        return descripcion;
    }
    public double getPrecioVenta() {
        return precioVenta;
    }
    public int getStock() {
        return stock;
    }

    // SETTERS
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPrecioVenta(double precio) {
        precioVenta = precio;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    // CONSTRUCTOR
    public Articulo(String descripcion, int cantidad, double precio) {
        this.descripcion = descripcion;
        precioVenta = precio;
        stock = cantidad;
    }

    // DEFINIMOS LAS FUNCIONES
    public boolean hayStock() {
        return stock > 0;
    }
    public double consultarPrecio(){
        return precioVenta;
    }
    public static void cambiarMoneda(String moneda) { // METODO DE CLASE, SE DEFINE STATIC PARA QUE NO SE PUEDA USAR COMO UN OBJETO
        Articulo.moneda = moneda; // ACCEDEMOS A LA VARIABLE DESDE LA CLASE PARA CAMBIAR SU VALOR
    }
}
