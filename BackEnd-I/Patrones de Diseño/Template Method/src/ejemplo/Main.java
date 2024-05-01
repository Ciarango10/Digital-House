package ejemplo;

public class Main {
    public static void main(String[] args) {
        Cocinero cocineroVeggie = new CocineroVeggie();
        Cocinero cocineroNoVeggie = new CocineroNoVeggie();

        cocineroNoVeggie.hacerPizza();
        cocineroVeggie.hacerPizza();
    }
}