package ejemplo;

public class Oro implements Observador{

    @Override
    public String actualizar() {
        return this + "> Cambio de estado: ";
    }
}
