public class Main {
    public static void main(String[] args) {
        //DECLARACIÓN DE VARIABLES
        String nombre = "Carlos";
        double sueldo = 700000.00;
        int edad = 18;
        boolean trabaja = true;
        System.out.println("Mi nombre es: " + nombre + " tengo " + edad + " años, y mi sueldo es de: " + sueldo + " Trabaja: " + trabaja);

        //SE PUEDEN DECLARAR LAS VARIABLES CON TIPOS DE DATOS COMO CLASES PARA ACCEDER A SUS METODOS
        Integer edad1 = 2;
        System.out.println(edad1.equals(2));
        Double renta = 600.00;
        System.out.println(renta.compareTo(600.00));
        Boolean mayorEdad = true;
        System.out.println(mayorEdad.equals(false));
    }
}