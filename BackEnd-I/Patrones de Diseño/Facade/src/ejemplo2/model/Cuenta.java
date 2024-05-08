package ejemplo2.model;

public class Cuenta {

    private String identificacion;
    private double saldo;

    public Cuenta(String identificacion, double saldo) {
        this.identificacion = identificacion;
        this.saldo = saldo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
