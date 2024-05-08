package ejemplo;


public class Main {

    private static final String comidas[] = {"Hamburguesa", "Pizza", "Perro", "Costilla"};

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Comida comida = ComidaFactory.getComida(comidaAleatoria());
            comida.setPrecio((i+1)*5);
            comida.setTieneLechuga(true);
            comida.descripcionDeLaComida();
        }

    }

    private static String comidaAleatoria() {
        return comidas[(int)(Math.random()* comidas.length)];
    }

}