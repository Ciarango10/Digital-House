package ejemploclase.dh.backend.service;

import ejemploclase.dh.backend.model.Empleado;
import ejemploclase.dh.backend.model.EmpleadoEfectivo;

public class LiquidadorEfectivo extends Liquidador{

    @Override
    public double calcularMonto(Empleado empleado) {
        if(empleado instanceof EmpleadoEfectivo empleadoEfectivo) {
            //EmpleadoEfectivo empleadoEfectivo = ((EmpleadoEfectivo) empleado);
            return empleadoEfectivo.getSueldoBase()+empleadoEfectivo.getPremios()-empleadoEfectivo.getDescuento();
        }
        return 0;
    }

    @Override
    public String imprimir(Empleado empleado) {
        return "documento impreso";
    }

}
