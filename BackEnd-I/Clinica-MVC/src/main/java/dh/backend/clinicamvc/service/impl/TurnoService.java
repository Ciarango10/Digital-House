package dh.backend.clinicamvc.service.impl;

import dh.backend.clinicamvc.dao.IDao;
import dh.backend.clinicamvc.model.Odontologo;
import dh.backend.clinicamvc.model.Paciente;
import dh.backend.clinicamvc.model.Turno;
import dh.backend.clinicamvc.service.ITurnoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    private IDao<Turno> turnoIDao;
    private IDao<Paciente> pacienteIDao;
    private IDao<Odontologo> odontologoIDao;

    public TurnoService(IDao<Turno> turnoIDao, IDao<Paciente> pacienteIDao, IDao<Odontologo> odontologoIDao) {
        this.turnoIDao = turnoIDao;
        this.pacienteIDao = pacienteIDao;
        this.odontologoIDao = odontologoIDao;
    }

    @Override
    public Turno registrarTurno(Turno turno) {
        Paciente paciente = pacienteIDao.buscarPorId(turno.getPaciente().getId());
        Odontologo odontologo = odontologoIDao.buscarPorId(turno.getOdontologo().getId());
        Turno turnoADevolver = null;

        if(paciente != null && odontologo != null) {
            turno.setPaciente(paciente);
            turno.setOdontologo(odontologo);
            turnoADevolver = turnoIDao.registrar(turno);
        }

        return turnoADevolver;
    }

    @Override
    public Turno buscarPorId(Integer id) {
        return turnoIDao.buscarPorId(id);
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnoIDao.buscarTodos();
    }

    @Override
    public void actualizarTurno(Turno turno) {
        Paciente paciente = pacienteIDao.buscarPorId(turno.getPaciente().getId());
        Odontologo odontologo = odontologoIDao.buscarPorId(turno.getOdontologo().getId());

        if(paciente != null && odontologo != null) {
            turno.setPaciente(paciente);
            turno.setOdontologo(odontologo);
            turnoIDao.actualizar(turno);
        }
    }

    @Override
    public void eliminarTurno(Integer id) {
        turnoIDao.eliminar(id);
    }
}
