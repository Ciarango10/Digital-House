package mesasdetrabajo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiguraTest {

    @Test
    @DisplayName("Testeo que el valor del radio sea mayor que cero")
    void test1() {
        Figura circulo = new Circulo(0.0);
        String valorEsperado = "El valor del radio o lado debe ser mayor que cero";
        String valorObtenido = circulo.calcularArea();
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    @DisplayName("Testeo que el valor del lado sea mayor que cero")
    void test2() {
        Figura cuadrado = new Cuadrado(-10);
        String valorEsperado = "El valor del radio o lado debe ser mayor que cero";
        String valorObtenido = cuadrado.calcularArea();
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    @DisplayName("Testeamos que el área del cuadrado sea correcta")
    void test3() {
        Figura cuadrado = new Cuadrado(4);
        String valorEsperado = "El área del Cuadrado es 16 unidades";
        String valorObtenido = cuadrado.calcularArea();
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    @DisplayName("Testeamos que el área del circulo sea correcta")
    void test4() {
        Figura circulo = new Circulo(5);
        String valorEsperado = "El área del Circulo es 79 unidades";
        String valorObtenido = circulo.calcularArea();
        assertEquals(valorEsperado, valorObtenido);
    }

}