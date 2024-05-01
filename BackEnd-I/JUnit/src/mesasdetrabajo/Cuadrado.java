package mesasdetrabajo;

public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    protected String calcularArea() {
        if(esValido(lado)) {
            return "El área del " + getClass().getSimpleName() + " es " + (int) Math.round(lado*lado) + " unidades";
        } else {
            return "El valor del radio o lado debe ser mayor que cero";
        }
    }
}
