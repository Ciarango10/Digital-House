package parcial;

public class ObraSocial extends Paciente{
    private String nombreObra;
    private int numeroAsociados;

    public ObraSocial(Consulta consulta, String fechaNacimiento, String nombre, String apellido, Boolean esPrimeraConsulta, String nombreObra, int numeroAsociados) {
        super(consulta, fechaNacimiento, nombre, apellido, esPrimeraConsulta);
        this.nombreObra = nombreObra;
        this.numeroAsociados = numeroAsociados;
    }

    public String Comparar(Object o) {
        if (this.getClass() != o.getClass()){
            return "Lo estas comparando con un objeto que no es de obra social";
        } else {
            ObraSocial obraSocial = (ObraSocial)o;
            if(this.numeroAsociados == obraSocial.numeroAsociados) {
                return "Iguales";
            }
            if (this.numeroAsociados > obraSocial.numeroAsociados){
                return "Mayor";
            }
            else {
                return "Menor";
            }
        }

    }

}
