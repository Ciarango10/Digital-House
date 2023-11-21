package com.company;

import java.util.Date;

public class Paciente {
    String nombre;
    String apellido;
    String historiaClinica;
    Date fechaInternacion;
    Date fechaAlta;


    Paciente(String nombre, String apellido, String historiaClinica, Date fechaInternacion)
    {   Date hoy= new Date();
        this.nombre=nombre;
        this.apellido=apellido;
        fechaAlta=null;
        if (fechaInternacion.before(hoy))
            this.fechaInternacion=fechaInternacion;
    }

    public Date getFechaInternacion() {
        return fechaInternacion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void darAlta(Date fechaAlta)
    {
        if (fechaAlta.after(fechaInternacion))
            System.out.println("Ok");
        else
            System.out.println("No se puede");
    }



}
