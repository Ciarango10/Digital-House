package operaciones;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("------ArrayList---------");

        // ARRAY LIST
        List arrayList = new ArrayList();

        // AGREGAR AL ARRAY LIST
        arrayList.add("Juan");
        arrayList.add("Mario");
        arrayList.add("Carlos");
        arrayList.add("Marcelo");
        arrayList.add("Marcelo");

        // RECORRER ARRAY LIST
        System.out.println("------Recorrer ArrayList---------");
        int i = 0;
        for(i=0;i<arrayList.size();i++) {
            System.out.println(arrayList.get(i));
        }

        // RECORRER ARRAY LIST CON ITERATOR
        System.out.println("------Recorrer ArrayList con Iterator---------");
        Iterator iterador = arrayList.iterator();
        while(iterador.hasNext()) {
            System.out.println(iterador.next());
        }

        // RECORRER ARRAY LIST CON FOR EACH
        System.out.println("------Recorrer ArrayList con ForEach---------");
        for(Object o: arrayList) {
            System.out.println(o);
        }


        System.out.println("-------LinkedList--------");
        // LINKED LIST
        List linkedList = new LinkedList();

        // AGREGAR AL LINKED LIST
        linkedList.add("Juan");
        linkedList.add("Mario");
        linkedList.add("Carlos");
        linkedList.add("Marcelo");
        linkedList.add("Marcelo");

        // RECORRER LINKED LIST CON FOR EACH
        for(Object o :linkedList) {
            System.out.println((String)o);
        }


        System.out.println("-------HashSet--------");
        // HASHSET
        Set hashset = new HashSet();

        // AGREGAR HASHSET
        hashset.add("Juan");
        hashset.add("Mario");
        hashset.add("Carlos");
        hashset.add("Marcelo");
        hashset.add("Marcelo");

        // RECORRER HASHSET CON FOR EACH
        for(Object o :hashset) {
            System.out.println((String)o);
        }

        System.out.println("--------LinkedHashSet-------");
        // LINKED HASHSET
        Set linkedhashset = new LinkedHashSet();

        // AGREGAR LINKED HASHSET
        linkedhashset.add("Juan");
        linkedhashset.add("Mario");
        linkedhashset.add("Carlos");
        linkedhashset.add("Marcelo");
        linkedhashset.add("Marcelo");

        // RECORRER LINKED HASHSET CON FOR EACH
        for(Object o :linkedhashset) {
            System.out.println((String)o);
        }


        System.out.println("--------TreeSet-------");
        // TREESET
        Set treeset = new TreeSet();

        // AGREGAR TREESET
        treeset.add("Juan");
        treeset.add("Mario");
        treeset.add("Carlos");
        treeset.add("Marcelo");
        treeset.add("Marcelo");

        // RECORRER TREESET CON FOR EACH
        for(Object o :treeset) {
            System.out.println((String)o);
        }


        System.out.println("--------HashMap-------");
        // HASHMAP
        Map hashmap = new HashMap();

        // AGREGAR HASHMAP
        hashmap.put(29888999,"Juan");
        hashmap.put(30888999,"Mario");
        hashmap.put(27888999,"Carlos");
        hashmap.put(40888999,"Marcelo");
        hashmap.put(50888999,"Marcelo");

        // OBTENER EL NOMBRE MEDIANTE DNI
        System.out.println("--------Obtener el nombre del DNI 27888999 -------");
        System.out.println(hashmap.get(27888999));

        // RECORRER HASHMAP CON FOR EACH
        System.out.println("--------Recorrido -------");
        for(Object o :hashmap.values()) {
            System.out.println((String)o);
        }


        System.out.println("--------LinkedHashMap-------");
        // LINKED HASHMAP
        Map linkedhashmap = new LinkedHashMap();

        // AGREGAR A LINKED HASHMAP
        linkedhashmap.put(29888999,"Juan");
        linkedhashmap.put(30888999,"Mario");
        linkedhashmap.put(27888999,"Carlos");
        linkedhashmap.put(40888999,"Marcelo");
        linkedhashmap.put(50888999,"Marcelo");

        // OBTENER EL NOMBRE MEDIANTE DNI
        System.out.println("--------Obtener el nombre del DNI 27888999 -------");
        System.out.println(linkedhashmap.get(27888999));

        // RECORRER LINKED HASHMAP CON FOR EACH
        System.out.println("--------Recorrido -------");
        for(Object o :linkedhashmap.values()) {
            System.out.println((String)o);
        }

        
        System.out.println("--------TreeMap-------");
        // TREEMAP
        Map treemap = new TreeMap();

        // AGREGAR A TREEMAP
        treemap.put(29888999,"Juan");
        treemap.put(30888999,"Mario");
        treemap.put(27888999,"Carlos");
        treemap.put(40888999,"Marcelo");
        treemap.put(50888999,"Marcelo");

        // OBTENER EL NOMBRE MEDIANTE DNI
        System.out.println("--------Obtener el nombre del DNI 27888999 -------");
        System.out.println(treemap.get(27888999));

        // RECORRER TREEMAP CON FOR EACH
        System.out.println("--------Recorrido -------");
        for(Object o :treemap.values()) {
            System.out.println((String)o);
        }

    }
}
