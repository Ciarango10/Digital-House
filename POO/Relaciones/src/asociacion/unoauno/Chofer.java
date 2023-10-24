package asociacion.unoauno;

public class Chofer {
    private String nombre;
    private String apellido;
    private Auto auto;

    public Chofer(String nombre, String apellido, Auto auto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.auto = auto;
    }

    public String verPatente() {
        return  auto.getPatente();
    }
}
