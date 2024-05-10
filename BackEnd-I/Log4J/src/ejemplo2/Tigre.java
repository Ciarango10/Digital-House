package ejemplo2;

import ejemplo.TestLog;
import org.apache.log4j.Logger;

public class Tigre {

    private static final Logger logger = Logger.getLogger(Tigre.class);
    private String nombre;
    private int edad;

    public Tigre(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void correr() {
        logger.info("El Tigre " + nombre + " está corriendo");
    }

}
