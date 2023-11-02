package ejercitacion;

public class CuentaCorriente extends Cuenta{
    private double monto;
    public CuentaCorriente(double saldo, Cliente cliente, double monto) {
        super(saldo, cliente);
        this.monto = monto;
    }
    @Override
    public void depositarEfectivo(double dinero) {
        saldo+=dinero;
    }
    @Override
    public void extraerEfectivo(double dinero) {
        if (dinero <= saldo) {
            saldo-=dinero;
        } else if (monto >= dinero){
            saldo-=dinero;
        }else {
            System.out.println("Monto insuficiente");
        }
    }
}
