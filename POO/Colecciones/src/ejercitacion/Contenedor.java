package ejercitacion;

import java.net.ConnectException;

public class Contenedor implements Comparable{
    private int identificador;
    private String procedencia;
    private boolean esPeligroso;

    public int getIdentificador() {
        return identificador;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public boolean getEsPeligroso() {
        return esPeligroso;
    }

    public Contenedor(int identificador, String procedencia, boolean esPeligroso) {
        this.identificador = identificador;
        this.procedencia = procedencia;
        this.esPeligroso = esPeligroso;
    }

    @Override
    public int compareTo(Object o) {
        Contenedor otroContenedor = (Contenedor) o;
        if(this.identificador > ((Contenedor) o).identificador) {
            return 1;
        } else if (this.identificador < ((Contenedor) o).identificador){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Contenedor{" +
                "identificador=" + identificador +
                ", procedencia='" + procedencia + '\'' +
                ", esPeligroso=" + esPeligroso +
                '}';
    }
}
