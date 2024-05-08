package ejemplomesas.dh.backend.service;

import ejemplomesas.dh.backend.model.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApiHotel {

    List<Hotel> hoteles;

    public ApiHotel() {
        hoteles = new ArrayList<>();
        cargarHoteles();
    }

    public boolean buscarHotel(LocalDate fechaIngreso, LocalDate fechaEgreso, String ciudad) {
        boolean respuesta = false;
        for (Hotel hotel: hoteles) {
            if(fechaIngreso.isEqual(hotel.getFechaEntrada()) && fechaEgreso.isEqual(hotel.getFechaSalida()) && hotel.getCiudad().equals(ciudad)) {
                System.out.println("El Hotel esta disponible");
                respuesta =  true;
            }
        }
        return respuesta;
    }

    public void cargarHoteles() {
        hoteles.add(new Hotel("Los Angeles", LocalDate.of(2024,06,20), LocalDate.of(2024,06,15)));
        hoteles.add(new Hotel("Paris", LocalDate.of(2024,07,15), LocalDate.of(2024,07,10)));
    }

}
