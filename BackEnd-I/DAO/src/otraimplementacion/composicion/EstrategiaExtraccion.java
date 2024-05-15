package otraimplementacion.composicion;

import otraimplementacion.Cuenta;

public interface EstrategiaExtraccion {
    public boolean extraer(Cuenta cuenta, double monto);
}
