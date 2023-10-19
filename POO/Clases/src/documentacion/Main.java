package documentacion;

public class Main {
    public static void main(String[] args) {

        Articulo articulo; // DECLARAMOS LA VARIABLE DE TIPO ARTICULO
        articulo = new Articulo("Articulo 1", 3, 2000); // INSTANCIAMOS UN OBJETO DE TIPO ARTICULO CON SU CONSTRUCTOR

        if (articulo.hayStock()) {
            System.out.println("Hay stock disponible");
        }

        Articulo.cambiarMoneda("Dolar"); // UTILIZAMOS EL METODO DE CLASE A TRAVES DE LA CLASE Y NO DEL OBJETO

        System.out.println("El precio de venta es " + articulo.consultarPrecio());

        articulo.setPrecioVenta(5000); // CAMBIAMOS EL PRECIO DE VENTA POR MEDIO DEL SET
        System.out.println(articulo.getPrecioVenta()); // OBTENEMOS EL PRECIO DE VENTA POR MEDIO DEL GET

    }
}