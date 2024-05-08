package ejemplo2.service;

import ejemplo2.model.Cuenta;

public class CuentaService {

    Cuenta cuenta;

    public CuentaService(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta(String DNI) {
        Cuenta c = null;

        if(cuenta.getIdentificacion().equals(DNI)) {
            c = cuenta;
        }

        return c;
    }

}
