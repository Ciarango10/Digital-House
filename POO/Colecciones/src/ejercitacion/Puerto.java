package ejercitacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Puerto {
    private String nombre;
    private List<Contenedor> contenedores;

    public String getNombre() {
        return nombre;
    }

    public List<Contenedor> getContenedores() {
        return contenedores;
    }

    public Puerto(String nombre) {
        this.nombre = nombre;
        contenedores = new ArrayList<>();
    }

    public void ingresarContenedores(Contenedor contenedor) {
        contenedores.add(contenedor);

        for (int i = 0; i < contenedores.size(); i++) {
            for (int j = i+1; j < contenedores.size(); j++) {
                if (contenedores.get(i).compareTo(contenedores.get(j)) > 0) {
                    Contenedor temp = contenedores.get(i);
                    contenedores.set(i,contenedores.get(j));
                    contenedores.set(j, temp);
                }
            }
        }
        System.out.println(contenedores);
    }

    public void cantidadContenedoresPeligrosos (List<Contenedor> contenedores) {
        int peligroso = 0;
        for (Object o: contenedores) {
            if (o instanceof Contenedor) {
                Contenedor contenedor = (Contenedor) o;
                if (contenedor.getEsPeligroso() && contenedor.getProcedencia().equals("Desconocido")) {
                    peligroso++;
                }
            }
        }
        System.out.println("Cantidad de contenedores peligrosos: " + peligroso);
    }
}
