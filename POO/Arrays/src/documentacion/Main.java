package documentacion;

public class Main {
    public static void main(String[] args) {

        String[] nombres; //CON LOS CORCHETES SE INDICA QUE ES UN ARRAY
        nombres = new String[5]; //SE DEBE DEFINIR DENTRO DE LOS CORCHETES EL TAMAÑO

        // OTRA FORMA DE DEFINIR UN ARREGLO
        String[] nombres2 = {"Ivan", "Efren","Hugo"};

        //ASIGNAR VALORES AL ARRAY, DADO QUE ES UNA ESTRUCTURA FIJA NO SE PUEDEN ELIMINAR ELEMENTOS
        nombres[0] = "Juan";
        nombres[1] = "Mario";
        nombres[2] = "Carlos";

        //ACCEDER A UN ELEMENTO POR SU INDICE
        System.out.println(nombres[0]);

        //RECORRER ARRAY CON UN CICLO FOR
        for(int i = 0; i<nombres.length; i++) {
            System.out.println(nombres[i]);
        }

        //RECORRER ARRAY CON UN CICLO WHILE
        int i = 0;
        while(i < nombres.length) {
            System.out.println(nombres[i]);
            i++;
        }

        //RECORRER ARRAY CON UN CICLO FOR EACH
        for(String nombre : nombres)
            System.out.println(nombre);
    }
}