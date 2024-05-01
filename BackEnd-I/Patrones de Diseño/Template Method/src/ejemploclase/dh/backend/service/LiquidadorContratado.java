package ejemploclase.dh.backend.service;

import ejemploclase.dh.backend.model.Empleado;
import ejemploclase.dh.backend.model.EmpleadoContratado;

public class LiquidadorContratado extends Liquidador{

    @Override
    public double calcularMonto(Empleado empleado) {
        if(empleado instanceof EmpleadoContratado empleadoContratado) {
            //EmpleadoContratado empleadoContratado = ((EmpleadoContratado) empleado);
            return empleadoContratado.getCantHoras()*empleadoContratado.getTarifaHora();
        }
        return 0;
    }

    @Override
    public String imprimir(Empleado empleado) {
        return "documento digital";
    }

}
