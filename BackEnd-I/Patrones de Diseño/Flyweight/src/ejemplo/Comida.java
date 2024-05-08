package ejemplo;

public class Comida {

    private String tipoComida;
    private int precio;
    private boolean tieneLechuga;

    public Comida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isTieneLechuga() {
        return tieneLechuga;
    }

    public void setTieneLechuga(boolean tieneLechuga) {
        this.tieneLechuga = tieneLechuga;
    }

    public void descripcionDeLaComida() {
        System.out.println("Es un/una " + getTipoComida() + " que sale: " + getPrecio());
    }

}
