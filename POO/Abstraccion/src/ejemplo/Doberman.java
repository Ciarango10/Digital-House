package ejemplo;

public class Doberman extends Perro {
    public Doberman(String nombre) {
        super(nombre);
    }

    @Override
    public String ladrar() {
        return "Ladro como un doberman GUAU!!!";
    }
}
