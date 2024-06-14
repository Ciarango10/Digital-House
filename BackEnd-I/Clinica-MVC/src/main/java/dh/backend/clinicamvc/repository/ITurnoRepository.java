package dh.backend.clinicamvc.repository;

import dh.backend.clinicamvc.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
    //Buscar Turnos entre dos fechas
    @Query("SELECT t FROM Turno t WHERE t.fecha BETWEEN :startDate AND :endDate")
    List<Turno> buscarTurnosEntreFechas(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    //Buscar Turnos posteriores a la fecha actual
    @Query("SELECT t FROM Turno t WHERE t.fecha > CURRENT_DATE")
    List<Turno> buscarTurnosPosterioresFechaActual();
}
