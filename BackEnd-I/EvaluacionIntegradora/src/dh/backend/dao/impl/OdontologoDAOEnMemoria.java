package dh.backend.dao.impl;

import dh.backend.dao.IDao;
import dh.backend.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOEnMemoria implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOEnMemoria.class);
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Integer id = odontologos.size()+1;
        odontologo.setId(id);

        odontologos.add(odontologo);
        LOGGER.info("Odontologo guardado: "+ odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Listado de todos los odontólogos en memoria: " + odontologos);
        return odontologos;
    }

}
