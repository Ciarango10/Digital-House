package ejemploclase.dh.backend.model;

public class EmpleadoContratado extends Empleado{

    private int cantHoras;
    private double tarifaHora;

    public EmpleadoContratado(String nombre, String apellido, String nroCuenta, int cantHoras, double tarifaHora) {
        super(nombre, apellido, nroCuenta);
        this.cantHoras = cantHoras;
        this.tarifaHora = tarifaHora;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

}
