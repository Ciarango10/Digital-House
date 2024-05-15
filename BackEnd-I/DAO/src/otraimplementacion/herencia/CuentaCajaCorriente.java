package otraimplementacion.herencia;

import otraimplementacion.Cuenta;

public class CuentaCajaCorriente extends Cuenta {

    @Override
    public boolean extraer(double monto) {
        setSaldo(getSaldo()-monto);
        return true;
    }

}
