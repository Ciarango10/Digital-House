package Documentacion;

import java.util.Date;
public class Main {
    public static void main(String[] args) {
        //DECLARACIÓN DE VARIABLES

        //TIPOS PRIMITIVOS ---------------------------------------------------------------------------------------------
        double sueldo = 700000.00;
        int edad = 18;
        boolean trabaja = true;

        //TIPO CLASES, NOS PERMITE EJECUTAR SUS METODOS ----------------------------------------------------------------
        //STRING
        String nombre = "CARLOS"; //UN STRING AL CUAL NO LE ASIGNAMOS NADA TIENE VALOR NULL, ESTO SUCEDE CON TODAS LAS CLASES
        String nombre2 = "carlos";
        if (nombre.toLowerCase().equals(nombre2)) {
            System.out.println("Son Iguales");
        } else {
            System.out.println("No son Iguales");
        }

        //DOUBLE
        Double renta = 600.00;
        //NO SE PUEDEN USAR OPERADORES COMO ==, PARA COMPARAR SE USA equals(), RETORNA TRUE O FALSE
        System.out.println(renta.equals(600.0));

        //INTEGER
        Integer edad1 = 5;
        Integer edad2 = 10;
        //PARA COMPARAR SI UN VALOR ES MAYOR A OTRO SE USA compareTo()
        // SI EL NUMERO ES MAYOR RETORNA 1, SI SON IGUALES RETORNA 0 y SI ES MENOR RETORNA -1
        if (edad1.equals(edad2)) {
            System.out.println("Son iguales");
        } else {
            if (edad1.compareTo(edad2) == 1) {
                System.out.println(edad1 + " es mayor a " + edad2);
            } else {
                System.out.println(edad2 + " es mayor a " + edad1);
            }
        }

        //FLOAT
        Float coeficiente = 2.5f; //SI NO SE PONE LA F SE ASUME QUE ES DE TIPO DOUBLE
        System.out.println(coeficiente);

        //DATE
        //PARA USAR DATE ES NECESARIO AGREGAR import java.util.Date;
        Date fecha = new Date();
        System.out.println(fecha.toString()); //MUESTRA LA FECHA Y HORA ACTUAL

        Date fechaNueva = new Date(105,0,31); //PARAMETROS SON AÑO(COMIENZA SIEMPRE EN 1900), MES(COMIENZA EN 0), DIA
        System.out.println(fechaNueva.toString());

        //BOOLEAN
        Boolean mayorEdad = true;
        System.out.println(mayorEdad.equals(false));

    }
}