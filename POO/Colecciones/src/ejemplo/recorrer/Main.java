package ejemplo.recorrer;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // ARRAY LIST
	    List nombres = new ArrayList();

        // AGREGAR AL ARRAY LIST
        nombres.add("Juan");
        nombres.add("Mario");
        nombres.add("Carlos");
        nombres.add("Diego");
        nombres.add("Marcelo");
        nombres.add("Marcelo");

        // FOR
        for(int i = 0; i < nombres.size(); i++) {
            System.out.println(nombres.get(i));
        }

        // WHILE
        int i = 0;
        boolean encontrado = false;
        while( i < nombres.size() && !encontrado)
        {
            if(nombres.get(i) == "Carlos")
                encontrado = true;
            System.out.println(nombres.get(i));
            i++;
        }

        // ITERATOR
        System.out.println("Usando Iterator");
        Iterator iterator = nombres.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        // FOR EACH
        System.out.println("Usando For Each");
        for(Object nombre: nombres){
            System.out.println(nombre);
        }


    }
}
