package ejerciciomesas.dh.backend.test;

import ejercicioclase.dh.backend.service.IServicioVacunacion;
import ejercicioclase.dh.backend.service.ProxyVacunacion;
import ejerciciomesas.dh.backend.model.TipoUsuario;
import ejerciciomesas.dh.backend.model.Usuario;
import ejerciciomesas.dh.backend.service.DescargaService;
import ejerciciomesas.dh.backend.service.ISpotify;
import ejerciciomesas.dh.backend.service.ProxyDescarga;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ISpotifyTest {

    @Test
    @DisplayName("La canción se puede descargar")
    void test1() {
        //dado
        Usuario usuario = new Usuario("101237891", TipoUsuario.PREMIUM);
        ISpotify proxy = new ProxyDescarga(new DescargaService());
        //cuando
        String respuesta = proxy.descargarCancion(usuario);
        //entonces
        assertEquals("Canción descargada exitosamente!", respuesta);
    }

    @Test
    @DisplayName("La canción no se puede descargar")
    void test2() {
        //dado
        Usuario usuario = new Usuario("101237891", TipoUsuario.FREE);
        ISpotify proxy = new ProxyDescarga(new DescargaService());
        //cuando
        String respuesta = proxy.descargarCancion(usuario);
        //entonces
        assertEquals("No tienes permitido descargar canciones, pasate a premium!", respuesta);
    }

}