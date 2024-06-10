package com.example.Apuestas.controller;

import com.example.Apuestas.entity.Torneo;
import com.example.Apuestas.service.TorneoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torneos")
public class TorneoController {

    private TorneoService torneoService;

    public TorneoController(TorneoService torneoService) {
        this.torneoService = torneoService;
    }

    @GetMapping
    public List<Torneo> listarTorneos() {
        return torneoService.listarTorneos();
    }

    @PostMapping
    public Torneo agregarTorneo(@RequestBody Torneo torneo) {
        return torneoService.agregarTorneos(torneo);
    }

}
