package ejemplo2;

import ejemplo.TestLog;
import org.apache.log4j.Logger;

public class Leon {

    private static final Logger logger = Logger.getLogger(Leon.class);
    private String nombre;
    private int edad;
    private boolean esAlfa;

    public Leon(String nombre, int edad, boolean esAlfa) {
        this.nombre = nombre;
        this.edad = edad;
        this.esAlfa = esAlfa;
    }

    public void correr() {
        logger.info("El león " + nombre + " está corriendo");
    }

    public void esMayorA10 () {
        if(edad > 10 && esAlfa) {
            logger.info("Es un leon alfa y tiene mas de 10 años");
        }
        if (edad < 0) {
            logger.error("La edad no puede ser negativa");
        }
    }

}
