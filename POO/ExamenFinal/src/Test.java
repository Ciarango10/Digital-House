public class Test {
    public static void main(String[] args) {
        PizzaSimple pizzaMozarella = new PizzaSimple("Mozzarela","Queso Artesanal", 700.00, false);
        PizzaSimple pizzaMargarita = new PizzaSimple("Margarita", "Mucha tocino", 850, true);
        PizzaSimple pizzaAnana = new PizzaSimple("Ananá", "Mucho queso", 950, false);

        PizzaCombinada pizzaLoca = new PizzaCombinada("PizzaLoca", "Mitad Margarita y Ananá");
        pizzaLoca.agregarPizzas(pizzaMargarita);
        pizzaLoca.agregarPizzas(pizzaAnana);

        System.out.println("*************************************\n"+
                "PRECIOS PIZZAS");
        System.out.println("Precio Mozarella: " + pizzaMozarella.calcular());
        System.out.println("Precio Margarita: " + pizzaMargarita.calcular());
        System.out.println("Precio Ananá: " + pizzaAnana.calcular());

        System.out.println("Precio Pizza Loca: " + pizzaLoca.calcular());


        System.out.println("*************************************\n" +
                "INFO PIZZAS");
        pizzaMozarella.mostrar();
        pizzaMargarita.mostrar();
        pizzaAnana.mostrar();
        pizzaLoca.mostrar();
    }
}