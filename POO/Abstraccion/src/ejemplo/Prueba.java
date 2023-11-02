package ejemplo;

public class Prueba {
    public static void main(String[] args) {

        // LAS CLASES ABSTRACTAS NO PUEDEN SER INSTANCIADAS
        // Perro perro3 = new Perro();

        // POLIMORFISMO
        Perro perro1 = new Doberman("Luna");
        System.out.println(perro1.ladrar());

        perro1 = new Caniche("Pedro");
        System.out.println(perro1.ladrar());

        // CASTEO IMPLICITO
        // CUANDO LE PIDO AL PADRE QUE TENGA LA RESPONSABILIDAD DEL HIJO
        Doberman doberman1 = new Doberman("Carlos");
        Perro perro2 = doberman1;

        // CASTEO EXPLICITO
        Perro otroPerro = new Doberman("Fredy");
        Doberman doberman2 = (Doberman) otroPerro;

    }
}
