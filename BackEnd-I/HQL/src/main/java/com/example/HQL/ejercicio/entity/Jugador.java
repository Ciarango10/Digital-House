package com.example.HQL.ejercicio.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String clubFavorito;

    public Jugador(String nombre, String clubFavorito) {
        this.nombre = nombre;
        this.clubFavorito = clubFavorito;
    }

    public Jugador() {
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

    public String getClubFavorito() {
        return clubFavorito;
    }

    public void setClubFavorito(String clubFavorito) {
        this.clubFavorito = clubFavorito;
    }

}
