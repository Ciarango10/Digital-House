package ejemplo3;

public class Main {

    public static final String canciones[] = {"Hotel California", "Somebody that I used to know", "Bohemian Rhapsody"};
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Cancion cancion = CancionFactory.getCancion(cancionAleatoria());
            cancion.setArtista("Freddy Mercurie");
            cancion.setGenero("Balada");
            cancion.getListaReproduccion();
        }
    }

    private static String cancionAleatoria() {
        return canciones[(int)(Math.random()*canciones.length)];
    }

}
