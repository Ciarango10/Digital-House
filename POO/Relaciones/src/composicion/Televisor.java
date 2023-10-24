package composicion;

public class Televisor {
    private String marca;
    private Pantalla pantalla;

    public Televisor() {
        pantalla = new Pantalla();
    }
}
