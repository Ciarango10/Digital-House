package ejercitacion;

public class Nave extends Objeto{
    private double velocidad;
    private int vida;

    public double getVelocidad() {
        return velocidad;
    }

    public int getVida() {
        return vida;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Nave(int posx, int posy, char direccion, double velocidad) {
        super(posx, posy, direccion);
        this.velocidad = velocidad;
        vida = 100;
    }

    @Override
    public void irA(int x, int y, char direccion) {
        if(direccion!=getDireccion()){
            girar(direccion);
            super.irA(x, y, direccion);
        }
        else{
            super.irA(x, y, direccion);
        }
    }
    public void girar(char direccion) {
        setDireccion(direccion);
    }
    public void restarVida(int valor) {
        vida -= valor;
    }
}
