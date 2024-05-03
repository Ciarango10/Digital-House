package ejercicio2;

public class DocumentoService implements IAccesoDocumento{

    @Override
    public void accederDocumento(String url, String email) {
        System.out.println("Acceso exitoso al documento " + url);
    }

}
