package com.example.Estudiantes.entity.dto;

import com.example.Estudiantes.entity.Estudiante;
import com.example.Estudiantes.entity.Materia;

public class CursadaDTO {

    private Long id;
    private double nota;
    private Estudiante estudiante;
    private Materia materia;

    public Long getId() {
        return id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
