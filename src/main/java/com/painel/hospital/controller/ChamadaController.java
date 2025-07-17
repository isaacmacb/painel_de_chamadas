package com.painel.hospital.controller;

import com.painel.hospital.dto.ChamadaDTO;
import com.painel.hospital.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chamadas")
@CrossOrigin(origins = "*")
public class ChamadaController {
    private final ConsultaService consultaService;

    public ChamadaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    public ResponseEntity<List<ChamadaDTO>> listarChamadas() {
        List<ChamadaDTO> chamadas = consultaService.listarChamadasDoDia();
        return ResponseEntity.ok(chamadas);
    }
}
