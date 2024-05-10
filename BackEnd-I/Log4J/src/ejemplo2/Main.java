package ejemplo2;

public class Main {

    public static void main(String[] args) {

        Leon leon = new Leon("Simba", 10, true);
        Leon leon2 = new Leon("Bom", 11, true);
        Leon leon3 = new Leon("Carlos", -10, true);

        leon.correr();
        leon2.correr();
        leon2.esMayorA10();
        leon3.esMayorA10();

        Tigre tigre = new Tigre("Freddie", 11);
        tigre.correr();

    }

}
