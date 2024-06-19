package dh.backend.clinicamvc.repository;

import dh.backend.clinicamvc.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}
