package ejerciciomesas.dh.backend.service;

import ejerciciomesas.dh.backend.model.Usuario;

public class DescargaService implements  ISpotify{

    @Override
    public String descargarCancion(Usuario usuario) {
        return "Canción descargada exitosamente!";
    }

}
