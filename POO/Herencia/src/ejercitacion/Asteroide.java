package ejercitacion;

public class Asteroide extends Objeto{
    private int lesion;

    public int getLesion() {
        return lesion;
    }

    public void setLesion(int lesion) {
        this.lesion = lesion;
    }

    public Asteroide(int x, int y, char direccion, int lesion) {
        super(x,y,direccion);
        this.lesion = lesion;
    }

    @Override
    public void irA(int x, int y, char direccion) {
        super.irA(x,y,direccion);
    }

}
