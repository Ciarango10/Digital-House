package ejercitacion;

public class Producto {
    private double precio;
    private String descripcion;

    public Producto(double precio, String descripcion) {
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
