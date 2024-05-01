package ejemplomesas.dh.backend.service;

import ejemplomesas.dh.backend.model.Menu;

public class ArmadoMenuInfantil extends ArmadoMenu{
    @Override
    public String armarMenu(Menu menu) {
        return "preparar menu infantil";
    }

    @Override
    public double calcularPrecioVenta(Menu menu) {
        return menu.getPrecioBase() + (menu.getJuguetes() * 3);
    }
}
