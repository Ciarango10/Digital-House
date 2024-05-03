package ejemplo;

public class Main {
    public static void main(String[] args) {
        EmpleadoBanco empleado1 = new EjecutivoDeCuenta();
        EmpleadoBanco empleado2 = new Gerente();
        EmpleadoBanco empleado3 = new Director();

        empleado1.setSigEmpleadoBanco(empleado2);
        empleado2.setSigEmpleadoBanco(empleado3);

        empleado1.procesarSolicitud(78000);
    }
}