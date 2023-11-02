package ejemplo;

public class Caniche extends Perro{
    public Caniche(String nombre) {
        super(nombre);
    }

    @Override
    public String ladrar() {
        return "Ladro como un caniche GUAU!!!";
    }
}
