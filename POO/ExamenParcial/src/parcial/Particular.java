package parcial;

public class Particular extends Paciente{
    private Double precioConsulta;
    private String DNI;

    public Particular(Consulta consulta, String fechaNacimiento, String nombre, String apellido, Boolean esPrimeraConsulta, Double precioConsulta, String DNI) {
        super(consulta, fechaNacimiento, nombre, apellido, esPrimeraConsulta);
        this.precioConsulta = precioConsulta;
        this.DNI = DNI;
    }
}
