package ejercitacion;

public class CajaAhorro extends Cuenta{
    public CajaAhorro(double saldo, Cliente cliente, double interes) {
        super(saldo, cliente);
        this.interes = interes;
    }
    private double interes;
    @Override
    public void depositarEfectivo(double dinero) {
        saldo+=dinero;
    }
    @Override
    public void extraerEfectivo(double dinero) {
        if (dinero <= saldo) {
            saldo-=dinero;
        }else {
            System.out.println("Monto insuficiente");
        }
    }
    public void cobrarInteres() {
        saldo -= interes * saldo;
    }
}
