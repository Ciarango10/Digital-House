package ejemplo2.service;

public class AutenticacionService {

    public boolean validarUsuarioYContrasena(String DNI, String contrasenia) {
        boolean valido = false;
        if(DNI != null && contrasenia != null) {
            valido = true;
        }
        return valido;
    }

}
