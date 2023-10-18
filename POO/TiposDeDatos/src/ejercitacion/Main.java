package ejercitacion;
public class Main {
    public static void main(String[] args) {
        String tipoAnimal, nombre, pregunta;
        int edad;
        double cantidadComida;

        tipoAnimal = "Perro";
        nombre = "Manchitas";
        edad = 2;
        cantidadComida = 1.5;
        pregunta = "¡GUAU!";
        System.out.println("El animal es un " + tipoAnimal + " su nombre es " + nombre + " tiene "
                + edad + " años, come " + cantidadComida + " kilos, y  hace " + pregunta);

        tipoAnimal = "Pez";
        nombre = "Nemo";
        edad = 1;
        cantidadComida = 0.14;
        pregunta = "Plop";
        System.out.println("El animal es un " + tipoAnimal + " su nombre es " + nombre + " tiene "
                + edad + " año, come " + cantidadComida + " kilos, y  hace " + pregunta);

        tipoAnimal = "Gato";
        nombre = "Silvestre";
        edad = 3;
        cantidadComida = 0.5;
        pregunta = "¡MIAU!";
        System.out.println("El animal es un " + tipoAnimal + " su nombre es " + nombre + " tiene "
                + edad + " años, come " + cantidadComida + " kilos, y  hace " + pregunta);

        tipoAnimal = "Tortuga";
        nombre = "Manuelita";
        edad = 12;
        cantidadComida = 0.3;
        pregunta = "Pehuajó";
        System.out.println("El animal es un " + tipoAnimal + " su nombre es " + nombre + " tiene "
                + edad + " años, come " + cantidadComida + " kilos, y  vive en " + pregunta);

        tipoAnimal = "Pajaro";
        nombre = "Gardel";
        edad = 1;
        cantidadComida = 0.35;
        pregunta = "¡pío, pío, pío!";
        System.out.println("El animal es un " + tipoAnimal + " su nombre es " + nombre + " tiene "
                + edad + " año, come " + cantidadComida + " kilos, y  hace " + pregunta);
    }
}
