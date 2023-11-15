package parcial;

public class Paciente {
    protected Consulta consulta;
    protected String fechaNacimiento;
    protected String nombre;
    protected String apellido;
    protected Boolean esPrimeraConsulta;

    public Paciente(Consulta consulta, String fechaNacimiento, String nombre, String apellido, Boolean esPrimeraConsulta) {
        this.consulta = consulta;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.esPrimeraConsulta = esPrimeraConsulta;
    }

    protected boolean necesitaEvaluacionInicial() {
        return esPrimeraConsulta;
    }
}
