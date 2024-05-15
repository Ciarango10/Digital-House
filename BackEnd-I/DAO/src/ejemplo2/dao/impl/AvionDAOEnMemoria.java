package ejemplo2.dao.impl;

import ejemplo2.dao.IDao;
import ejemplo2.model.Avion;

import java.util.ArrayList;
import java.util.List;

public class AvionDAOEnMemoria implements IDao<Avion> {

    private List<Avion> aviones;

    public AvionDAOEnMemoria(List<Avion> aviones) {
        this.aviones = aviones;
    }

    @Override
    public Avion guardar(Avion avion) {
        aviones.add(avion);
        return avion;
    }

    @Override
    public Avion buscar(Long id) {
        Avion avionBuscado = null;
        for (Avion avion:aviones) {
            if(avion.getId().equals(id)) {
                avionBuscado = avion;
            }
        }
        return avionBuscado;
    }

    @Override
    public void eliminar(Long id) {
        Avion avion = buscar(id);
        aviones.remove(avion);
    }

    @Override
    public List<Avion> buscarTodos() {
        return aviones;
    }

}
