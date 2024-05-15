package ejemploclases.dh.backend.service;

import ejemploclases.dh.backend.dao.IDao;
import ejemploclases.dh.backend.model.Medicamento;

import java.util.List;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoDao;

    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public void setMedicamentoDao(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public Medicamento registrarMedicamento(Medicamento medicamento) {
        return medicamentoDao.registrar(medicamento);
    }

    public Medicamento buscarPorNombre(String nombre) {
        return medicamentoDao.buscarPorCampo(nombre);
    }

    public Medicamento buscarPorId(Integer id) {
        return medicamentoDao.buscarPorId(id);
    }

    public List<Medicamento> buscarTodos() {
        return medicamentoDao.buscarTodos();
    }

}
