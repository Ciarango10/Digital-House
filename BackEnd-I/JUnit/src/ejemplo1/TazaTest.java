package ejemplo1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TazaTest {
    @Test
    public void getTipoLiquido() {
        Taza taza = new Taza("Jugo de Naranja", 70.5);
        assertEquals("Jugo de Naranja", taza.getTipoLiquido());
    }
    @Test
    public void getPorcentaje() {
        Taza taza = new Taza("Jugo de Naranja", 70.5);
        assertEquals(70.5, taza.getPorcentaje());
    }
}