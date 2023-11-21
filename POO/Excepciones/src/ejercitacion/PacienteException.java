package ejercitacion;

public class PacienteException extends Exception{
    public PacienteException (String mensaje) {
        super(mensaje);
    }
    public String toString()
    {
        return "Se produjo el siguiente Excepción " + this.getClass().getName() +"\n" +
                " Mensaje: " + this.getMessage() + "\n" ;
    }
}
