package ejemploclase.dh.backend.service;

import ejemploclase.dh.backend.model.Empleado;

public abstract class Liquidador {

    public String liquidarSueldo(Empleado empleado) {
        String respuesta = "La liquidacion no pudo ser calculada";
        //Paso 1: calcular sueldo
        double sueldo = calcularMonto(empleado);
        if(sueldo > 0) {
            //Paso 2: imprimir
            String imprimir = imprimir(empleado);
            //Paso 3: depositar
            depositar(empleado);

            return respuesta = "La liquidacion generada es un " + imprimir + ". Saldo a liquidar: " + sueldo;
        }
        return respuesta;
    }

    public abstract double calcularMonto(Empleado empleado);

    public abstract String imprimir(Empleado empleado);

    public void depositar(Empleado empleado) {
        System.out.println("Estoy depositando en la caja de ahorros " + empleado.getNroCuenta());
    }

}
