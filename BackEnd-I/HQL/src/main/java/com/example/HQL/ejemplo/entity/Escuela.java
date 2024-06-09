package com.example.HQL.ejemplo.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Escuela {

    @Id
    @SequenceGenerator(name = "escuela_sequence", sequenceName = "escuela_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "escuela_sequence")
    private Long id;
    private String nombre;
    private String direccion;

    public Escuela() {
    }

    public Escuela(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
