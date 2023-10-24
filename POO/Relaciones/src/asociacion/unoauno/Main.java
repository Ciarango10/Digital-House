package asociacion.unoauno;

public class Main {
    public static void main(String[] args) {
        // DISTINTAS FORMAS DE CREAR UN CHOFER

        // CREAMOS EL AUTO EN EL CHOFER
        Chofer chofer1 = new Chofer("Carlos", "Arango", new Auto("Abc123", "Ford","Fiesta"));

        // CREAMOS EL AUTO Y LO PASAMOS EN EL CONSTRUCTOR DEL CHOFER
        Auto auto = new Auto("Abc123", "Ford","Fiesta");
        Chofer chofer2 = new Chofer("Carlos", "Arango", auto);

        System.out.println("Patente de auto asignado: " + chofer1.verPatente());
    }
}
