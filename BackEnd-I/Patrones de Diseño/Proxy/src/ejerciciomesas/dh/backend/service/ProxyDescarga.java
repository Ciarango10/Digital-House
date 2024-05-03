package ejerciciomesas.dh.backend.service;

import ejerciciomesas.dh.backend.model.TipoUsuario;
import ejerciciomesas.dh.backend.model.Usuario;

public class ProxyDescarga implements ISpotify{

    private DescargaService descargaService;

    public ProxyDescarga(DescargaService descargaService) {
        this.descargaService = descargaService;
    }

    @Override
    public String descargarCancion(Usuario usuario) {
        if(usuario.getTipoUsuario().equals(TipoUsuario.PREMIUM)) {
            return descargaService.descargarCancion(usuario);
        }
        return "No tienes permitido descargar canciones, pasate a premium!";
    }

}
