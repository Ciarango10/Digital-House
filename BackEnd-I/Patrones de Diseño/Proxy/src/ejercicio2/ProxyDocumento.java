package ejercicio2;

import java.util.List;

public class ProxyDocumento implements IAccesoDocumento{

    private int id;
    private String url;
    private String contenido;
    private List<String> usuariosAutorizados;
    private DocumentoService documento;

    public ProxyDocumento(int id, String url, String contenido, List<String> usuariosAutorizados, DocumentoService documento) {
        this.id = id;
        this.url = url;
        this.contenido = contenido;
        this.usuariosAutorizados = usuariosAutorizados;
        this.documento = documento;
    }

    @Override
    public void accederDocumento(String url, String email) {
        if(this.usuariosAutorizados.contains(email)) {
            if(this.url.equals(url)) {
                this.documento.accederDocumento(url, email);
            } else {
                System.out.println("El documento no existe, verifique la url");
            }
        } else {
            System.out.println("No tiene acceso a este documento");
        }
    }
}
