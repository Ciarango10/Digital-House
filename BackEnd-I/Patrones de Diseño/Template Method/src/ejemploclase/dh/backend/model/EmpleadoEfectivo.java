package ejemploclase.dh.backend.model;

public class EmpleadoEfectivo extends Empleado{

    private double sueldoBase;
    private double descuento;
    private double premios;

    public EmpleadoEfectivo(String nombre, String apellido, String nroCuenta, double sueldoBase, double descuento, double premios) {
        super(nombre, apellido, nroCuenta);
        this.sueldoBase = sueldoBase;
        this.descuento = descuento;
        this.premios = premios;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPremios() {
        return premios;
    }

    public void setPremios(double premios) {
        this.premios = premios;
    }

}
