package ejemplo3;

public class Cancion {

    private String nombre;
    private String artista;
    private String genero;

    public Cancion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void getListaReproduccion() {
        System.out.println("La cancion: " + getNombre() + " pertenece a la lista Clasicos en ingles");
    }

}
