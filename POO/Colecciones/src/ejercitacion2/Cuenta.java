package ejercitacion2;

public class Cuenta implements Comparable<Cuenta>{
    private int nroCuenta;
    private double saldo;
    public Cuenta(int nroCuenta, double saldo) {
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }
    public int getNroCuenta() {
        return nroCuenta;
    }
    @Override
    public int compareTo(Cuenta o) {
        if(this.nroCuenta > o.nroCuenta) {
            return 1;
        } else if (this.nroCuenta < o.nroCuenta) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "nroCuenta=" + nroCuenta +
                ", saldo=" + saldo +
                '}';
    }
}
