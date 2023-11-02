package ejercitacion;

public abstract class Cuenta {
    public Cuenta(double saldo, Cliente cliente) {
        this.saldo = saldo;
        this.cliente = cliente;
    }
    protected double saldo;
    private Cliente cliente;
    public abstract void depositarEfectivo(double dinero);
    public abstract void extraerEfectivo(double dinero);
    public void informarSaldo() {
        System.out.println("El saldo del cliente " + cliente +" es de: " + saldo);
    }
}
