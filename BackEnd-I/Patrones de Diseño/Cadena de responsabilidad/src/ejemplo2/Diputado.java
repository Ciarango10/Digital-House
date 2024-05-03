package ejemplo2;

public class Diputado extends EmpleadoGobierno{

    @Override
    public void leerDocumento(Documento documento) {
        if (documento.getTipo() == 1) {
            System.out.println("Yo me encargo de leerlo. Diputado");
        }
        if(getSigEmpleadoGobierno() != null) {
            getSigEmpleadoGobierno().leerDocumento(documento);
        }
    }

}
