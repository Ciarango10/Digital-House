package ejemplo2.service;

import ejemplo2.model.Cuenta;

public class RetiroService implements IRetiroService{

    AutenticacionService autenticacionService;
    CuentaService cuentaService;
    CajaService cajaService;

    public RetiroService(AutenticacionService autenticacionService, CuentaService cuentaService, CajaService cajaService) {
        this.autenticacionService = autenticacionService;
        this.cuentaService = cuentaService;
        this.cajaService = cajaService;
    }

    @Override
    public void procesarRetiro(String nroIdentificacion, String contrasenia, double saldoRetirar) {

        if(!autenticacionService.validarUsuarioYContrasena(nroIdentificacion, contrasenia)) {
            System.out.println("Error de autenticacion, verifique los datos ingresados");
            return;
        }
        Cuenta cuenta = cuentaService.getCuenta(nroIdentificacion);
        if(cuenta == null) {
            System.out.println("La cuenta con identificacion: " + nroIdentificacion + " no existe!.");
            return;
        }
        if(cuenta.getSaldo() < saldoRetirar) {
            System.out.println("Saldo insuficiente");
            return;
        }
        cajaService.entregarDinero(saldoRetirar);
        cuenta.setSaldo(cuenta.getSaldo() - saldoRetirar);

        System.out.println("Retiro exitoso. Saldo actual: " + cuenta.getSaldo());
    }

}
