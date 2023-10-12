package Documentacion;

import java.util.Scanner; //NECESARIO PARA USAR ESCANER

public class Main {
    public static void main(String[] args) {
        Scanner lector; //DEFINICION DEL OBJET0 LECTOR
        lector = new Scanner(System.in); //INSTANCIACION DEL OBJETO
        int num1, num2;
        float coeficiente;
        String nombre, apellido;
        char inicialNombre, inicialApellido;

        //INGRESAR ENTEROS
        System.out.println("Ingrese el primer valor:");
        num1 = lector.nextInt();
        System.out.println(num1);

        System.out.println("Ingrese el segundo valor:");
        num2 = lector.nextInt();
        System.out.println(num2);

        //INGRESAR FLOTANTES
        System.out.println("Ingrese el coeficiente:");
        coeficiente = lector.nextFloat();
        System.out.println(coeficiente);

        lector.nextLine(); //CUANDO UTILIZAS LECTOR.NEXTLINE() DESPUÉS DE INGRESAR VALORES NUMÉRICOS CON LECTOR.NEXTINT(), EL
        // LECTOR.NEXTLINE() CAPTURA LA LÍNEA EN BLANCO QUE QUEDA DESPUÉS DEL ÚLTIMO VALOR NUMÉRICO INGRESADO.
        // CON ESTA LINEA SE SOLUCIONA EL PROBLEMA

        //INGRESAR TEXTO
        System.out.println("Ingrese su nombre:");
        nombre = lector.nextLine();
        System.out.println(nombre);

        System.out.println("Ingrese su Apellido:");
        apellido = lector.nextLine();
        System.out.println(apellido);

        inicialNombre = nombre.charAt(0); //SE OBTIENE EL PRIMER CARACTER DEL NOMBRE
        inicialApellido = apellido.charAt(0); //SE OBTIENE EL PRIMER CARACTER DEL APELLIDO
        System.out.println(inicialNombre+ "" +inicialApellido);

        lector.close(); // CERRAR EL SCANNER Y LIBERAR RECURSOS
    }
}