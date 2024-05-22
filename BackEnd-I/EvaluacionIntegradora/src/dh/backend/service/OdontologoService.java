package dh.backend.service;

import dh.backend.dao.IDao;
import dh.backend.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listarTodos() {
        return odontologoIDao.listarTodos();
    }

}
