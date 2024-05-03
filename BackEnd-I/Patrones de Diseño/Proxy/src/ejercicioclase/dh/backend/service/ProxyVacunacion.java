package ejercicioclase.dh.backend.service;

import ejercicioclase.dh.backend.model.Persona;

import java.time.LocalDate;

public class ProxyVacunacion implements IServicioVacunacion{

    private Vacunacion vacunacion;

    public ProxyVacunacion(Vacunacion vacunacion) {
        this.vacunacion = vacunacion;
    }

    @Override
    public String vacunar(Persona persona) {
        if(persona.getFechaVacunacion().isEqual(LocalDate.now()) || persona.getFechaVacunacion().isBefore(LocalDate.now())) {
            return vacunacion.vacunar(persona);
        }
        return "La persona no cumple con los requisitos";
    }

}
