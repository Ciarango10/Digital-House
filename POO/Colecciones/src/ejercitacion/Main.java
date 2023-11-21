package ejercitacion;

public class Main {
    public static void main(String[] args) {
        Contenedor contenedor1 = new Contenedor(981, "Rusia,", false);
        Contenedor contenedor2 = new Contenedor(123, "China", true);
        Contenedor contenedor3 = new Contenedor(111, "EEUU", false);
        Contenedor contenedor4 = new Contenedor(231, "Desconocido", true);

        Puerto puerto1 = new Puerto("Caucasia");
        puerto1.ingresarContenedores(contenedor1);
        puerto1.ingresarContenedores(contenedor2);
        puerto1.ingresarContenedores(contenedor3);
        puerto1.ingresarContenedores(contenedor4);

        puerto1.cantidadContenedoresPeligrosos(puerto1.getContenedores());
    }

}
