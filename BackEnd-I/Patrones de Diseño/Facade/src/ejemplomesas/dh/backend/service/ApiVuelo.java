package ejemplomesas.dh.backend.service;

import ejemplomesas.dh.backend.model.Hotel;
import ejemplomesas.dh.backend.model.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApiVuelo {

    List<Vuelo> vuelos;

    public ApiVuelo() {
        vuelos = new ArrayList<>();
        cargarVuelos();
    }

    public boolean buscarVuelo(LocalDate fechaEntrada, LocalDate fechaSalida, String origen, String destino) {
        boolean respuesta = false;
        Vuelo vueloABuscar = new Vuelo(origen, destino, fechaSalida, fechaEntrada);
        for (Vuelo vuelo: vuelos) {
            if(vuelo.equals(vueloABuscar)) {
                System.out.println("El vuelo esta disponible");
                respuesta =  true;
            }
        }
        return respuesta;
    }

    public void cargarVuelos() {
        vuelos.add(new Vuelo("Buenos Aires", "Los Angeles", LocalDate.of(2024,06,20), LocalDate.of(2024,06,15)));
        vuelos.add(new Vuelo("Santiago", "Paris", LocalDate.of(2024,07,15), LocalDate.of(2024,07,10)));
    }

}
