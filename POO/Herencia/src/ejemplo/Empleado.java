package ejemplo;
public class Empleado  extends Persona{
    protected double sueldo;
    protected double descuento;
    private String legajo;

    public String getLegajo() {
        return legajo;
    }

    public Empleado(String nombre, String dni, String legajo) {
        super(nombre,dni);
        this.legajo = legajo;
        sueldo = 30000;
        descuento = 5000;
    }

    public double calcularSueldo() {
        return sueldo - descuento;
    }

    // SOBRECARGA DEL METODO calcularSueldo()
    public double calcularSueldo(double premio) {
        return sueldo - descuento + premio;
    }

    // SOBREESCRIBIR EL METODO toString()
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" + "dni: " + dni;
    }

    // SOBREESCRIBIR EL METODO hashCode()
    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash*nombre.hashCode();
        hash = hash*dni.hashCode();
        return hash;
    }

    // SOBREESCRIBIR EL METODO equals()
    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        // VERIFICAREMOS QUE EL OBJETO QUE SE PASO POR PARAMETRO SEA UN EMPLEADO
        if (!(o instanceof Empleado) || this.getClass() != o.getClass()) { // DOS FORMAS DE VERIFICAR SI SON DE LA MISMA CLASE(EMPLEADO)
            return false;
        } else {
            Empleado empleadoAux = (Empleado)o; // CASTING
            return this.getLegajo().equals(empleadoAux.getLegajo());
        }
    }
}
