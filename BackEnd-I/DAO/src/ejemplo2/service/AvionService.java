package ejemplo2.service;

import ejemplo2.dao.IDao;
import ejemplo2.model.Avion;

import java.util.List;

public class AvionService {

    private IDao<Avion> avionDao;

    public AvionService() {
    }

    public AvionService(IDao<Avion> avionDao) {
        this.avionDao = avionDao;
    }

    public void setAvionDao(IDao<Avion> avionDao) {
        this.avionDao = avionDao;
    }

    public Avion guardarAvion(Avion avion) {
        return avionDao.guardar(avion);
    }

    public void eliminarAvion(Long id) {
        avionDao.eliminar(id);
    }

    public Avion buscar(Long id) {
        return avionDao.buscar(id);
    }

    public List<Avion> buscarTodos() {
        return avionDao.buscarTodos();
    }

}
