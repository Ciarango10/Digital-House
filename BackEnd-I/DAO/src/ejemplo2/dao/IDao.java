package ejemplo2.dao;

import java.util.List;

public interface IDao<T> {

    T guardar(T t);
    void eliminar(Long id);
    T buscar(Long id);
    List<T> buscarTodos();

}
