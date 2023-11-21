package ejercitacion;

import documentacion.excepcionespropias.FechaException;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws PacienteException {
	    Paciente paciente=new Paciente("Juan","Perez","12345",new Date(123,10,21));
        paciente.darAlta(new Date(123,10,20));
    }
}
