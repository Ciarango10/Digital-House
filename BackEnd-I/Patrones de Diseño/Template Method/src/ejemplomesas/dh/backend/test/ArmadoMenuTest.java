package ejemplomesas.dh.backend.test;

import ejemplomesas.dh.backend.model.Menu;
import ejemplomesas.dh.backend.service.ArmadoMenu;
import ejemplomesas.dh.backend.service.ArmadoMenuClasico;
import ejemplomesas.dh.backend.service.ArmadoMenuInfantil;
import ejemplomesas.dh.backend.service.ArmadoMenuVegetariano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmadoMenuTest {

    @Test
    void testearMenuClasico() {
        //dado
        Menu menu = new Menu(5000,0.1,2,3);
        ArmadoMenu armadoMenu = new ArmadoMenuClasico();
        //cuando
        String respuestaEsperada = "El menu se prepara: preparar menu clasico y tiene un costo de: 5000.0";
        String respuestaObtenida = armadoMenu.armarMenu(menu);
    }

    @Test
    void testearMenuVegetariano() {
        //dado
        Menu menu = new Menu(5000,0.1,2,3);
        ArmadoMenu armadoMenu = new ArmadoMenuVegetariano();
        //cuando
        String respuestaEsperada = "El menu se prepara: preparar menu clasico y tiene un costo de: 5054.0";
        String respuestaObtenida = armadoMenu.armarMenu(menu);
    }

    @Test
    void testearMenuInfantil() {
        //dado
        Menu menu = new Menu(5000,0.1,2,3);
        ArmadoMenu armadoMenu = new ArmadoMenuInfantil();
        //cuando
        String respuestaEsperada = "El menu se prepara: preparar menu clasico y tiene un costo de: 5009.0";
        String respuestaObtenida = armadoMenu.armarMenu(menu);
    }

}