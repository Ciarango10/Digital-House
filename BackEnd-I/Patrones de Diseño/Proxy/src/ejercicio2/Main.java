package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> usuariosAutorizados = new ArrayList<>();
        usuariosAutorizados.add("carlosarango3101@gmail.com");
        usuariosAutorizados.add("sa2508@gmail.com");

        IAccesoDocumento proxy;
        proxy = new ProxyDocumento(1, "www.googleDocs.com","Lorem Ipsum", usuariosAutorizados, new DocumentoService());
        proxy.accederDocumento("www.googleDocs.com", "carlosarango3101@gmail.com");
        proxy.accederDocumento("www.googleDoc.com", "sa2508@gmail.com");
        proxy.accederDocumento("www.googleDocs.com", "carlosarango3101@hotmail.com");
    }

}
