package documentacion.throwexception;

public class Main {

    public static void main(String[] args) {

        // RunTimeException
        Fecha1 fecha1 = new Fecha1(100, -100, 1000);

        // Exception
	    try {
            Fecha2 fecha2 = new Fecha2(100,-100,1000);
        } catch (Exception e) {
            System.err.println("No son valores validos para una fecha");
        }
    }
}
