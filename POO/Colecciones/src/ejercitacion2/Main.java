package ejercitacion2;

public class Main {
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta(612341819, 6000.00);
        Cuenta cuenta2 = new Cuenta(134135155, 8000.00);
        Cuenta cuenta3 = new Cuenta(728935222, 4000.00);
        Cuenta cuenta4 = new Cuenta(541231351, 3500.00);
        Cuenta cuenta5 = new Cuenta(981241711, 1100.00);

        Persona persona = new Persona("Carlos", "Arango", 18);

        System.out.println(persona.getNombreCompleto());
        System.out.println(persona.esMayorEdad());

        persona.agregarCuentas(cuenta1);
        persona.agregarCuentas(cuenta2);
        persona.agregarCuentas(cuenta3);
        persona.agregarCuentas(cuenta4);
        persona.agregarCuentas(cuenta5);

        System.out.println(persona.getSaldoTotal());
        persona.mostrarCuentas();
    }
}
