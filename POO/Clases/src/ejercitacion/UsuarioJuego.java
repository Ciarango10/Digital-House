package ejercitacion;

public class UsuarioJuego {
    private String nombre;
    private String clave;
    private double puntaje = 0;
    private int nivel = 0;

    // GETTERS
    public String getNombre() {
        return nombre;
    }
    public String getClave() {
        return clave;
    }
    public double getPuntaje() {
        return puntaje;
    }
    public int getNivel() {
        return nivel;
    }

    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    // CONSTRUCTOR
    public UsuarioJuego(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }
    public void aumentarPuntaje() {
        this.puntaje+=1;
    }
    public void subirNivel() {
        this.nivel+=1;
    }
    public void bonus(int valor) {
        this.puntaje += valor;
    }
}
