package ejemplo;

public class Persona implements Comparable{
    private int edad;
    public int getEdad() {
        return this.edad;
    }
    public void decirEdad() {
        System.out.println(this.edad);
    }
    @Override
    public int compareTo(Object o) {
        // FORMA LARGA DE HACERLO-----------------------
        // Persona p = (Persona) o;
        // if(this.edad > p.getEdad()) {
        //     return 1;
        // }
        // else if (this.edad < p.getEdad()) {
        //     return -1;
        // }
        // return 0;

        // FORMA CORTA DE HACERLO-------------------------
        return this.edad - ((Persona) o).getEdad();
    }
}
