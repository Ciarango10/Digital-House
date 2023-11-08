package ejercitacion;

public class Cliente {
    public static void main(String[] args) {
        CuentaCorriente cuenta = new CuentaCorriente();
        cuenta.depositar(2000);
        cuenta.informarSaldo();

        double impuesto = cuenta.gravar(10);
        System.out.println("Impuesto gravado: " + impuesto);
        cuenta.informarSaldo();
    }
}
