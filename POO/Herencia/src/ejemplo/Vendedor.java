package ejemplo;

public class Vendedor extends Empleado{
    private int comision;
    private double importeVentas;

    public Vendedor(String nombre, String dni, String legajo) {
        super(nombre, dni, legajo);
    }

    // SOBREESCRITURA
    @Override // INDICA QUE SE ANULA EL COMPORTAMIENTO ANTERIOR DEL METODO, LO ESTAMOS SOBREESCRIBIENDO PARA DARLE UNA FORMA DISTINTA DE RESOLVER
    public double calcularSueldo() {
        return sueldo - descuento + importeVentas/100*comision;
    }
    @Override
    public double calcularSueldo(double premio) {
        return sueldo - descuento + premio + importeVentas/100*comision;
    }

}
