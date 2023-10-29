package ejemplo;

public class Main {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Carlos", "1025643641","12314");
        Empleado empleado2 =new Empleado("Ivan","1025643641", "12314");
        Empleado empleado3 =new Empleado("Juan Carlos","1112", "12313");

        System.out.println("Sueldo a cobrar: " + empleado1.calcularSueldo());
        System.out.println("Sueldo a cobrar: " + empleado1.calcularSueldo(5000));

        // METODO toSring() SOBREESCRITO
        System.out.println(empleado1.toString());

        // METODO hashCode() SOBREESCRITO
        System.out.println(empleado1.hashCode());

        // METODO equals() SOBREESCRITO
        if (empleado1.equals(empleado2))
            System.out.println(empleado1.toString() + " es el mismo empleado que \n" +
                    empleado2.toString());
        else
            System.out.println(empleado1.toString() + " no es el mismo empleado que \n" +
                    empleado2.toString());

        if (empleado1.equals(empleado3))
            System.out.println(empleado1.toString() + " es el mismo empleado que \n" +
                    empleado3.toString());
        else
            System.out.println(empleado1.toString() + " no es el mismo empleado que \n " +
                    empleado3.toString());
    }
}