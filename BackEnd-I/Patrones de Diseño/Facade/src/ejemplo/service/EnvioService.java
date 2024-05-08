package ejemplo.service;

import ejemplo.model.Direccion;
import ejemplo.model.Producto;

public class EnvioService {

    public void procesarEnvio(Producto producto, Direccion direccion){
        System.out.println("Enviando producto a " + direccion.getCalle() +" "+ direccion.getNro() +","+ direccion.getBarrio());
    }

}
