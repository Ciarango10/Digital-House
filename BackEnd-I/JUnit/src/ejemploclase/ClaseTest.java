package ejemploclase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClaseTest {
    @Test
    void testearQueSeanIguales() {
        int num1 = 1;
        int num2 = 1;

        assertEquals(num1,num2);
        assertNotEquals(num1,2);
    }

    @Test
    void testearQueSeanVerdaderoOFalso() {
        assertTrue(9>7);
        assertFalse(9<7);
    }

}
