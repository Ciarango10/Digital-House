package ejemploclase;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListaNumeros {

    private static final Logger LOGGER = Logger.getLogger(ListaNumeros.class);
    List<Integer> lista = new ArrayList<>();

    public void agregarNumeros(Integer numero) {
        lista.add(numero);
        LOGGER.debug("Numero agregado " + numero);
        if(lista.size() > 5) {
            LOGGER.info("La longitud de la lista es mayor a 5");
        }
        if(lista.size() > 10) {
            LOGGER.info("La longitud de la lista es mayor a 10");
        }
    }

    public double promedio() {
        double promedio = 0.0;
        Integer suma = 0;
        for (Integer numero: lista) {
            suma += numero;
        }

        if(lista.isEmpty()) {
            LOGGER.error("La lista no puede tener cero elementos");
            return promedio;
        }

        try {
            promedio = (double) suma / lista.size();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("El promedio es: " + promedio);
        return promedio;
    }

}
