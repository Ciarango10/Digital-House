package ejercitacion2;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Cuenta> cuentas;
    public String getNombreCompleto() {
        return nombre + ' ' + apellido;
    }
    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        cuentas = new ArrayList<>();
    }
    public boolean esMayorEdad() {
        return edad > 60;
    }
    public double getSaldoTotal() {
        double saldoTotal = 0.0;
        for (Cuenta cuenta:cuentas) {
            saldoTotal += cuenta.getSaldo();
        }
        return saldoTotal;
    }
    public void agregarCuentas(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
    public void mostrarCuentas() {
        for (int i=0; i < cuentas.size(); i++) {
            for (int j = i + 1; j < cuentas.size(); j++) {
                if (cuentas.get(i).getNroCuenta() > cuentas.get(j).getNroCuenta()) {
                    Cuenta temp = cuentas.get(i);
                    cuentas.set(i, cuentas.get(j));
                    cuentas.set(j, temp);
                }
            }
        }
        System.out.println(cuentas);
    }
}
