package ejercitacion;

public class CajaDeAhorro extends Cuenta{
    private static final double intereses_caja_ahorro = 1.2; // CONSTANTE
    @Override
    public void extraer(double monto) {
        if(monto <= saldo) {
            saldo -= monto;
            System.out.println("Monto a extraer: " + monto);
            System.out.println("Saldo restante: " + saldo);
        } else {
            System.out.println("Saldo Insuficiente");
        }
    }

    public void cobrarIntereses() {
        saldo += saldo * (intereses_caja_ahorro/100);
    }

}
