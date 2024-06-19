package dh.backend.clinicamvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="especialidades")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo;

    @ManyToMany(mappedBy = "especialidades")
    @JsonIgnore
    private Set<Odontologo> odontologos = new HashSet<>();

    public Especialidad(String tipo) {
        this.tipo = tipo;
    }

}
