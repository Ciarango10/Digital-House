package ejercicio;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> sitiosBloqueados = new ArrayList<>();
        sitiosBloqueados.add("www.youtube.com");
        sitiosBloqueados.add("www.facebook.com");
        IConexionInternet proxy;
        proxy = new ProxyInternet(new InternetService(), sitiosBloqueados);

        proxy.conectarCon("www.google.com");
        proxy.conectarCon("www.youtube.com");
    }
}