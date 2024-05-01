package ejemplomesas.dh.backend.service;

import ejemplomesas.dh.backend.model.Menu;

public class ArmadoMenuVegetariano extends ArmadoMenu{
    @Override
    public String armarMenu(Menu menu) {
        return "preparar menu vegetariano";
    }

    @Override
    public double calcularPrecioVenta(Menu menu) {
        return menu.getPrecioBase() + (menu.getRecargoEspecias() * menu.getPrecioBase()) + (menu.getSalsas() * 2);
    }
}
