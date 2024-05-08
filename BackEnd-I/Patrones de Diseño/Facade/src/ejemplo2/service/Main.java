package ejemplo2.service;

import ejemplo2.model.Cuenta;

public class Main {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("1025643641", 500000);
        IRetiroService retiroService = new RetiroService(new AutenticacionService(), new CuentaService(cuenta), new CajaService());

        retiroService.procesarRetiro("1025643641", "12345", 300000);
    }

}
