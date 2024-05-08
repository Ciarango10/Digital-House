package ejerciciomesas.dh.backend.model;

public class Arbol {

    private int alto;
    private int ancho;
    private String color;
    private String tipoArbol;
    private static int contador = 0;

    public Arbol(int alto, int ancho, String color, String tipoArbol) {
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
        this.tipoArbol = tipoArbol;
        contador++;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoArbol() {
        return tipoArbol;
    }

    public void setTipoArbol(String tipoArbol) {
        this.tipoArbol = tipoArbol;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Arbol.contador = contador;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "alto=" + alto +
                ", ancho=" + ancho +
                ", color='" + color + '\'' +
                ", tipoArbol='" + tipoArbol + '\'' +
                '}';
    }

}
