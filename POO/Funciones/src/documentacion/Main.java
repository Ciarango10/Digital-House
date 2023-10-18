package documentacion;

public class Main {
    public static void main(String[] args) {
        boolean divisible = esDivisible(10,3);
        System.out.println(divisible);

        mostrarMensaje("Hola Mundo");

        int suma = sumar(10,5);
        System.out.println(suma);

        String saludo = obtenerSaludo("Carlos");
        System.out.println(saludo);
    }
    public static boolean esDivisible(int n, int divisor) //FUNCION QUE RETORNA BOOLEANO
    {
        return n % divisor == 0;
    }
    public static void mostrarMensaje(String mensaje) //FUNCION QUE NO RETORNA NADA
    {
        System.out.println(mensaje);
    }
    public static int sumar(int a, int b) //FUNCION QUE RETORNA ENTERO
    {
        return a + b;
    }
    public static String obtenerSaludo(String nombre) //FUNCION QUE RETORNA UN STRING
    {
        String saludo = "¡Hola, " + nombre + "!";
        return saludo;
    }
}