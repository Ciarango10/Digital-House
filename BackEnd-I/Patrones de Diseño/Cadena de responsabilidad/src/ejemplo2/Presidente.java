package ejemplo2;

public class Presidente extends EmpleadoGobierno{

    @Override
    public void leerDocumento(Documento documento) {
        System.out.println("Yo me encargo de leerlo. Presidente");
        if(getSigEmpleadoGobierno() != null) {
            getSigEmpleadoGobierno().leerDocumento(documento);
        }
    }

}
