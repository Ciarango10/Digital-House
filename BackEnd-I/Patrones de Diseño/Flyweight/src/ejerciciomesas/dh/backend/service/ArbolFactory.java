package ejerciciomesas.dh.backend.service;

import ejerciciomesas.dh.backend.model.Arbol;

import java.util.HashMap;

public class ArbolFactory {

    private static final HashMap<String, Arbol> arbolMap = new HashMap<>();

    public static Arbol plantarArboles(String tipoArbol) {
        Arbol arbol = (Arbol) arbolMap.get(tipoArbol);

        if(arbol == null) {
            switch (tipoArbol) {
                case "Ornamentales":
                    arbol = new Arbol(200,400,"Verde", tipoArbol);
                    break;
                case "Frutales":
                    arbol = new Arbol(500,300,"Rojo", tipoArbol);
                    break;
                case "Florales":
                    arbol = new Arbol(100,200,"Celeste", tipoArbol);
                    break;
                default:
                    System.out.println("No existe ese tipo de arbol");
            }
            arbolMap.put(tipoArbol, arbol);
            System.out.println("Arbol creada " + arbol);
        } else {
            System.out.println("Arbol encontrado " + arbol);
        }

        return arbol;
    }

}
