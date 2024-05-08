package ejemplomesas.dh.backend.model;

import java.time.LocalDate;

public class Hotel {

    private String ciudad;
    private LocalDate fechaSalida;
    private LocalDate fechaEntrada;

    public Hotel(String ciudad, LocalDate fechaSalida, LocalDate fechaEntrada) {
        this.ciudad = ciudad;
        this.fechaSalida = fechaSalida;
        this.fechaEntrada = fechaEntrada;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

}
