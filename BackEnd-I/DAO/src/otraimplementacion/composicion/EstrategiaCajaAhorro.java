package otraimplementacion.composicion;

import otraimplementacion.Cuenta;

public class EstrategiaCajaAhorro implements EstrategiaExtraccion{
    @Override
    public boolean extraer(Cuenta cuenta, double monto) {
        boolean resultado = false;
        if (cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo()-monto);
            resultado = true;
        }
        return resultado;
    }
}
