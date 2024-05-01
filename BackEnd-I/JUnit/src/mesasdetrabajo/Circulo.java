package mesasdetrabajo;

public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    protected String calcularArea() {
        if(esValido(radio)) {
            return "El área del " + getClass().getSimpleName() + " es " + (int) Math.round(Math.PI*(radio*radio)) + " unidades";
        } else {
            return "El valor del radio o lado debe ser mayor que cero";
        }
    }
}
