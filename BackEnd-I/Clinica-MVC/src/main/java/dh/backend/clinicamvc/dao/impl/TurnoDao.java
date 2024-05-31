package dh.backend.clinicamvc.dao.impl;

import dh.backend.clinicamvc.dao.IDao;
import dh.backend.clinicamvc.model.Turno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurnoDao implements IDao<Turno> {
    private static Logger LOGGER = LoggerFactory.getLogger(TurnoDao.class);
    private List<Turno> turnos;

    public TurnoDao(List<Turno> turnos) {
        this.turnos = turnos;
    }

    @Override
    public Turno registrar(Turno turno) {
        Integer id = turnos.size()+1;
        turno.setId(id);
        turnos.add(turno);
        LOGGER.info("Turno creado: " + turno);
        return turno;
    }

    @Override
    public Turno buscarPorId(Integer id) {
        for(Turno turno: turnos) {
            if(turno.getId().equals(id)) {
                LOGGER.info("Turno encontrado: " + turno);
                return turno;
            }
        }
        LOGGER.info("Turno no encontrado");
        return null;
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }

    @Override
    public void actualizar(Turno turno) {
        for (Turno t: turnos) {
            if(t.getId().equals(turno.getId())) {
                t.setPaciente(turno.getPaciente());
                t.setOdontologo(turno.getOdontologo());
                t.setFecha(turno.getFecha());
                LOGGER.info("Turno actualizado: " + turno);
                break;
            }
        }
        LOGGER.info("Turno no actualizado");
    }

    @Override
    public void eliminar(Integer id) {
        Turno turnoAEliminar = null;
        for (Turno turno: turnos) {
            if(turno.getId().equals(id)) {
                turnoAEliminar = turno;
                break;
            }
        }
        turnos.remove(turnoAEliminar);
        LOGGER.info("Turno eliminado");
    }

}
