package com.painel.hospital.controller;
import com.painel.hospital.dto.PacienteRequest;
import com.painel.hospital.dto.PacienteResponse;
import com.painel.hospital.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteResponse> cadastrarPacientes(@RequestBody PacienteRequest pacienteRequest) {
        PacienteResponse pacienteResponse = pacienteService.cadastrarPaciete(pacienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteResponse);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listarPacientes() {
        List<PacienteResponse> pacientes = pacienteService.listarTodos();
        return ResponseEntity.ok(pacientes);
    }
}
