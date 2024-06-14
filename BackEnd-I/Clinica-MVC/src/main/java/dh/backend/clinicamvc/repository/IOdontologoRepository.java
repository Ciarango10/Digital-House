package dh.backend.clinicamvc.repository;

import dh.backend.clinicamvc.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {
    //Buscar Odontólogos por apellido
    @Query("SELECT o FROM Odontologo o WHERE LOWER(o.apellido) = LOWER(:apellido)")
    List<Odontologo> findByApellido(@Param("apellido") String apellido);

    //Buscar Odontólogos por nombre
    @Query("SELECT o FROM Odontologo o WHERE LOWER(o.nombre) LIKE LOWER(CONCAT('%',:nombre,'%'))")
    List<Odontologo> findByNombreLike(@Param("nombre") String nombre);
}
