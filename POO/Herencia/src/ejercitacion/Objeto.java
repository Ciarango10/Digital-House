package ejercitacion;

import java.util.Objects;

public class Objeto {
    private int posx;
    private int posy;
    private char direccion;

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public char getDireccion() {
        return direccion;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public void setDireccion(char direccion) {
        this.direccion = direccion;
    }

    public Objeto(int posx, int posy, char direccion) {
        this.posx = posx;
        this.posy = posy;
        this.direccion = direccion;
    }

    public void irA(int x, int y, char direccion) {
        posx = x;
        posy = y;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "posx=" + posx +
                ", posy=" + posy +
                ", direccion=" + direccion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }
        else{
            Objeto objetoAux = (Objeto) o;
            return this.getPosx() == objetoAux.getPosx() && this.getPosy() == objetoAux.getPosy() && this.getDireccion() == objetoAux.getDireccion();
        }
    }

}
