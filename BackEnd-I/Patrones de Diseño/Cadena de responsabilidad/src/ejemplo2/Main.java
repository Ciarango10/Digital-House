package ejemplo2;

public class Main {
    public static void main(String[] args) {
        Documento documento = new Documento("Saludo al presidente", 3);

        EmpleadoGobierno presidente = new Presidente();
        EmpleadoGobierno ministro = new Ministro();
        EmpleadoGobierno diputado = new Diputado();

        diputado.setSigEmpleadoGobierno(ministro);
        ministro.setSigEmpleadoGobierno(presidente);

        diputado.leerDocumento(documento);
    }
}
