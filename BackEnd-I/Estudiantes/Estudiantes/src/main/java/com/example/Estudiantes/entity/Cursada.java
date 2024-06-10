package com.example.Estudiantes.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Cursadas")
public class Cursada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double nota;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;

    public Cursada(double nota, Estudiante estudiante, Materia materia) {
        this.nota = nota;
        this.estudiante = estudiante;
        this.materia = materia;
    }

    public Cursada() {
    }

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
