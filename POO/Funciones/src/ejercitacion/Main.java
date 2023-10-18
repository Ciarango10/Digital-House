package ejercitacion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //INSTANCIAMOS EL SCANNER

        System.out.println("Ingresa el numero: ");
        int num = scanner.nextInt();
        boolean primo = esPrimo(num);
        System.out.println(primo);

        System.out.println("Ingresa el numero 1: ");
        int num1 = scanner.nextInt();
        System.out.println("Ingresa el numero 2: ");
        int num2 = scanner.nextInt();
        System.out.println("Ingresa el numero 3: ");
        int num3 = scanner.nextInt();
        int maximo = maximoEntreTresNumeros(num1,num2,num3);
        System.out.println(maximo);

        scanner.nextLine();

        System.out.println("Ingrese el texto 1: ");
        String texto1 = scanner.nextLine();
        System.out.println("Ingrese el texto 2: ");
        String texto2 = scanner.nextLine();
        boolean distintas = cadenasDeTextoDistintas(texto1,texto2);
        System.out.println(distintas);
    }
    public static boolean esPrimo(int num)
    {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int maximoEntreTresNumeros(int num1, int num2, int num3)
    {
        int max = num1;

        if (num2 > max) {
            max = num2;
        }

        if (num3 > max) {
            max = num3;
        }

        return max;
    }

    public static boolean cadenasDeTextoDistintas(String unTextoA, String unTextoB)
    {
       if (unTextoA.equals(unTextoB)) {
           return false;
       } else {
           return true;
       }
    }

}
