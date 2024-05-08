package ejemplo2;

public class Circulo {

    private String color;
    private double radio;
    private String tamanio;

    public Circulo(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public void dibujar() {
        System.out.println("Dibujamos objeto color: " + getColor());
    }

}
