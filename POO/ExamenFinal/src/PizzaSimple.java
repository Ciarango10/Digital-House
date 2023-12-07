import java.io.OutputStream;

public class PizzaSimple extends Pizza implements Comparable<PizzaSimple> {
    private double precioBase;
    private boolean esEspecial;

    public PizzaSimple(String nombre, String descripcion, double precioBase, boolean esEspecial) {
        super(nombre, descripcion);
        this.precioBase = precioBase;
        this.esEspecial = esEspecial;
    }

    @Override
    public double calcular() {
        if(esEspecial) {
           return precioBase * 1.7;
        }
        return precioBase;
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre:" + getNombre() + ", Precio:" + calcular());
    }

    @Override
    public int compareTo(PizzaSimple o) {
        PizzaSimple pizza = (PizzaSimple)o;
        int respuesta = 0;

        if(this.calcular() > pizza.calcular()) {
            respuesta = 1;
        }
        if(this.calcular() < pizza.calcular()) {
            respuesta = -1;
        }

        return respuesta;
    }

}
