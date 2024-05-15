package otraimplementacion;

import otraimplementacion.composicion.EstrategiaCajaAhorro;
import otraimplementacion.composicion.EstrategiaCuentaCorriente;
import otraimplementacion.herencia.CuentaCajaAhorro;
import otraimplementacion.herencia.CuentaCajaCorriente;

public class Main {

    public static void main(String[] args) {

        //RESOLVIENDO POR HERENCIA -----------------------------------------------------------
        //Vinculación Dinámica
        Cuenta cuenta = new CuentaCajaAhorro();
        cuenta.setSaldo(1000);
        //Polimorfismo
        cuenta.extraer(1100);

        Cuenta cuenta2 = new CuentaCajaCorriente();
        cuenta2.setSaldo(cuenta.getSaldo());
        cuenta = cuenta2;

        cuenta.extraer(1100);
        System.out.println(cuenta.getSaldo());
        //FIN HERENCIA ------------------------------------------------------------------------

        //RESOLVIENDO POR COMPOSICIÓN----------------------------------------------------------
        Cuenta cuenta3 = new Cuenta();
        cuenta3.setSaldo(2000);
        cuenta3.setNumero(1101);
        cuenta3.setEstrategia(new EstrategiaCajaAhorro());

        cuenta3.extraer(2100);

        cuenta3.setEstrategia(new EstrategiaCuentaCorriente());
        cuenta3.extraer(2100);
        System.out.println(cuenta3.getSaldo());
        //FIN COMPOSICIÓN-----------------------------------------------------------------------


    }

}
