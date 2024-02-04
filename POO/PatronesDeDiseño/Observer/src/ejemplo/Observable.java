package ejemplo;

public interface Observable {

    public void agregar(Observador o);

    public void quitar(Observador o);

    public void notificar(String cambio);
}
