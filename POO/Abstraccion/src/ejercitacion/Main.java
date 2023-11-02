package ejercitacion;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1,"Arango","1025643641","123900");
        CajaAhorro cuentaAhorro = new CajaAhorro(720000.00,cliente1,0.10);
        CuentaCorriente cuentaCorriente = new CuentaCorriente(720000.00,cliente1, 1000000.00);

        cuentaAhorro.extraerEfectivo(721000.00);
        cuentaAhorro.informarSaldo();

        cuentaAhorro.depositarEfectivo(100000.00);
        cuentaAhorro.informarSaldo();

        cuentaAhorro.cobrarInteres();
        cuentaAhorro.informarSaldo();

        cuentaCorriente.extraerEfectivo(721000.00);
        cuentaCorriente.informarSaldo();

        cuentaCorriente.depositarEfectivo(211000.00);
        cuentaCorriente.informarSaldo();
    }
}
