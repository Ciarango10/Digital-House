package ejemplomesas.dh.backend.service;

import ejemplomesas.dh.backend.model.Menu;

public class ArmadoMenuClasico extends ArmadoMenu{
    @Override
    public String armarMenu(Menu menu) {
        return "preparar menu clasico";
    }

    @Override
    public double calcularPrecioVenta(Menu menu) {
        return menu.getPrecioBase();
    }
}
