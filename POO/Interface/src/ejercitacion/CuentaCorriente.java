package ejercitacion;

public class CuentaCorriente extends Cuenta implements GravadorImpuesto {
    private double permitidoDescubierto;
    @Override
    public void extraer(double monto) {
        if (monto <= saldo+permitidoDescubierto) {
            saldo -= monto;
            System.out.println("Saldo restante: " + saldo);
        } else {
            System.out.println("Excedente de descubierto permitido");
        }
    }
    @Override
    public double gravar(double porcentaje) {
        double impuesto = saldo*(porcentaje/100);
        saldo -= impuesto;
        return impuesto;
    }
}
