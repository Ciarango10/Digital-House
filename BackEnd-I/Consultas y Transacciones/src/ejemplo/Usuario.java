package ejemplo;

public class Usuario {

    private int id;
    private String nombre;
    private String email;
    private double sueldo;

    public Usuario(String nombre, String email, double sueldo) {
        this.nombre = nombre;
        this.email = email;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double subirSueldo(double precio) {
        this.sueldo += precio;
        return this.sueldo;
    }

}
