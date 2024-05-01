package ejemploanimal;

public class Animal {

    private String tipo; //caballo, perro, gato
    private String tamano; //grande, mediano, chico
    private int peso;

    public Animal(String tipo, String tamano, int peso) {
        this.tipo = tipo;
        this.tamano = tamano;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean esPesado() {
        return this.peso > 2000 && this.tamano.equals("grande");
    }
}
