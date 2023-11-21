package ejercitacion;

import documentacion.excepcionespropias.FechaException;

import java.util.Date;

public class Paciente {
    String nombre;
    String apellido;
    String historiaClinica;
    Date fechaInternacion;
    Date fechaAlta;


    Paciente(String nombre, String apellido, String historiaClinica, Date fechaInternacion) throws PacienteException
    {   Date hoy= new Date();
        this.nombre=nombre;
        this.apellido=apellido;
        fechaAlta=null;
        if (fechaInternacion.before(hoy))
            this.fechaInternacion=fechaInternacion;
        else {
            throw new PacienteException("La fecha de internacion no puede ser despues del dia actual");
        }
    }

    public Date getFechaInternacion() {
        return fechaInternacion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void darAlta(Date fechaAlta) throws PacienteException
    {
        if (fechaAlta.after(fechaInternacion))
            System.out.println("Ok");
        else
            throw new PacienteException("La fecha de alta no puede ser anterior a la fecha de internación");
    }

}
