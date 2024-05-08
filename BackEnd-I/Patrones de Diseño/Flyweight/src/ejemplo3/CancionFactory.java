package ejemplo3;

import java.util.HashMap;

public class CancionFactory {

    private static final HashMap<String, Cancion> listaReproduccionMap = new HashMap<>();

    public static Cancion getCancion(String nombre) {

        Cancion cancion = (Cancion) listaReproduccionMap.get(nombre);

        if (cancion == null) {
            cancion = new Cancion(nombre);
            listaReproduccionMap.put(nombre, cancion);
            System.out.println("Creo una cancion llamada: " + nombre);
        }

        return cancion;
    }

}
