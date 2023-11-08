package ejercitacion;

public abstract class Cuenta {
    protected double saldo;
    public abstract void extraer(double monto);
    public void depositar(double monto ){
        saldo += monto;
        System.out.println("EL monto ingresado es: " + monto);
    }
    public void informarSaldo(){
        System.out.println("Saldo total de la cuenta es: " + saldo);
    }
}
