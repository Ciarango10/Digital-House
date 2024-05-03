package ejemplo2;

public class Ministro extends EmpleadoGobierno{

    @Override
    public void leerDocumento(Documento documento) {
        if (documento.getTipo() == 1 || documento.getTipo() == 2 ) {
            System.out.println("Yo me encargo de leerlo. Ministro");
        }
        if(getSigEmpleadoGobierno() != null) {
            getSigEmpleadoGobierno().leerDocumento(documento);
        }
    }

}
