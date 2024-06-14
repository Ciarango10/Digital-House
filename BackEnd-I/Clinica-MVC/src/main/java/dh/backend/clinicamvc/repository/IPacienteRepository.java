package dh.backend.clinicamvc.repository;

import dh.backend.clinicamvc.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    //Buscar paciente por DNI
    @Query("SELECT p FROM Paciente p WHERE p.DNI LIKE CONCAT('%',:dni,'%')")
    Paciente findByDNI(@Param("dni") String dni);

    //Listar pacientes cuyo domicilio se encuentre en una provincia particular
    @Query("SELECT p FROM Paciente p JOIN p.domicilio d WHERE LOWER(d.provincia) = LOWER(:provincia)")
    List<Paciente> findByProvincia(@Param("provincia") String provincia);
}
