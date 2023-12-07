import java.util.ArrayList;
import java.util.List;

public class PizzaCombinada extends Pizza{

    private List<PizzaSimple> pizzas;

    public PizzaCombinada(String nombre, String descripcion) {
        super(nombre, descripcion);
        this.pizzas = new ArrayList<>();
    }

    @Override
    public double calcular() {
        double precioMayor = 0.0;
        for(int i = 0; i < pizzas.size()-1; i++) {
            if(pizzas.get(i).compareTo(pizzas.get(i+1)) > 0) {
                precioMayor = pizzas.get(i).calcular();
            }
        }
        return precioMayor;
    }

    public void agregarPizzas(PizzaSimple pizza) {
        pizzas.add(pizza);
    }

    @Override
    public void mostrar() {
        System.out.println(getNombre()+ "{");
        pizzas.forEach(Pizza::mostrar);
        System.out.println("Precio Final: " + calcular());
        System.out.println("}");

    }

}
