package ejercicioclase.dh.backend.service;

import ejercicioclase.dh.backend.model.Persona;

public class Vacunacion implements IServicioVacunacion{

    @Override
    public String vacunar(Persona persona) {
        return "La persona: " + persona.getNombre() + " " +persona.getApellido() + " se vacunó con: " + persona.getVacuna();
    }

}
