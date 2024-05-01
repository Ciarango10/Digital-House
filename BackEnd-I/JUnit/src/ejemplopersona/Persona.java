package ejemplopersona;

public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private int edad;

    public Persona(String nombre, String apellido, String email, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
    }

    public String nombreCompleto() {
        return nombre + " " + apellido;
    }

    public boolean esMayorEdad() {
        return edad >= 18;
    }
}
