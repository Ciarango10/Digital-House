package ejemplo;

public abstract class Perro {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Perro(String nombre) {
        this.nombre = nombre;
    }

    public abstract String ladrar();
}
