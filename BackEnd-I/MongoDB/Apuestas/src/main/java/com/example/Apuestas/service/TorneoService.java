package com.example.Apuestas.service;

import com.example.Apuestas.entity.Torneo;
import com.example.Apuestas.repository.ITorneosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoService {

    private ITorneosRepository torneosRepository;

    public TorneoService(ITorneosRepository torneosRepository) {
        this.torneosRepository = torneosRepository;
    }

    public List<Torneo> listarTorneos() {
        return torneosRepository.findAll();
    }

    public Torneo agregarTorneos(Torneo torneo) {
        return torneosRepository.save(torneo);
    }

}
