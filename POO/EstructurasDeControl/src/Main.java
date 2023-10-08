public class Main {
    public static void main(String[] args) {
        // ESTRUCTURAS DE DECISION
        //IF - ELSE
        boolean verdadero = true;
        if (verdadero) {
            System.out.println("Verdadero");
        } else {
            System.out.println("Falso");
        }
        //SWITCH
        int edad = 19;
        switch(edad) {
            case 18:
                System.out.println("Mayor de edad");
                break;
            case 17, 16, 15:
                System.out.println("Menor de edad");
                break;
            default:
                System.out.println("Edad no valida");
        }
        
        //ESTRUCTURAS DE REPETICION
        //FOR
        for(int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        //WHILE
        int j = 0;
        while(j < 5) {
            System.out.println("Hola");
            j++;
        }

        //EJERCICIO DE PRUEBA
        int num1 = 110;
        int num2 = 2;
        if (num1 % num2 == 0) {
            System.out.println("Es divisible");
            System.out.println(num1 / num2);
        } else {
            System.out.println("No es divisible");
            System.out.println((double)num1 / num2);
        }
    }
}