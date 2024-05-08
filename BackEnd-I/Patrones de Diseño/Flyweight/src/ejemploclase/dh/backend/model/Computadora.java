package ejemploclase.dh.backend.model;

public class Computadora {

    private String tipo;
    private int ram;
    private int discoDuro;
    private static int contador = 0;

    public Computadora(String tipo, int ram, int discoDuro) {
        this.tipo = tipo;
        this.ram = ram;
        this.discoDuro = discoDuro;
        contador++;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Computadora.contador = contador;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "tipo='" + tipo + '\'' +
                ", ram=" + ram +
                ", discoDuro=" + discoDuro +
                '}';
    }

}
