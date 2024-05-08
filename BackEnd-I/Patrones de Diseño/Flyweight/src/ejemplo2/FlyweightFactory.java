package ejemplo2;

import ejemplo.Comida;

import java.util.HashMap;

public class FlyweightFactory {

    private static final HashMap<String, Circulo> circuloMap = new HashMap<>();

    public static Circulo getCirculo (String color) {
        Circulo circulo = (Circulo) circuloMap.get(color);

        if(circulo == null) {
            circulo = new Circulo(color);
            circuloMap.put(color, circulo);
            System.out.println("Creo un circulo de color: " + color);
        }

        return circulo;
    }

}
