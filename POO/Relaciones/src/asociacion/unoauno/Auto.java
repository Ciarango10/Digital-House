package asociacion.unoauno;

import javax.management.remote.JMXAddressable;

public class Auto {
    private String patente;
    private String modelo;
    private String marca;
    private Motor motor;

    public Auto(String patente, String modelo, String marca) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        motor = new Motor();
    }

    public String getPatente() {
        return patente;
    }
}
