package mesasdetrabajo;

public abstract class Figura {

    protected boolean esValido(double valor) {
        return valor > 0;
    };
    protected abstract String calcularArea();

}
