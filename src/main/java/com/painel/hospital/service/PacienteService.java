package com.painel.hospital.service;

import com.painel.hospital.dto.PacienteRequest;
import com.painel.hospital.dto.PacienteResponse;
import com.painel.hospital.entity.Paciente;
import com.painel.hospital.entity.TipoAtendimento;
import com.painel.hospital.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.repository = pacienteRepository;
    }

    public PacienteResponse cadastrarPaciete(PacienteRequest request) {
        // ✅ Validação manual dos campos obrigatórios
        if (request.getNome() == null || request.getNome().isBlank()) {
            throw new IllegalArgumentException("O campo 'nome' é obrigatório.");
        }

        if (request.getTipoAtendimento() == null) {
            throw new IllegalArgumentException("O campo 'tipoAtendimento' é obrigatório.");
        }

        String prefixo = request.getTipoAtendimento() == TipoAtendimento.PRIORITARIO ? "P" : "N";
        Long contador = repository.countByTipoAtendimento(request.getTipoAtendimento()) + 1;
        String senha = String.format("%s%d-%s", prefixo, contador, request.getNome().toUpperCase());


        Paciente paciente = Paciente.builder()
                .nome(request.getNome())
                .tipoAtendimento(request.getTipoAtendimento())
                .senha(senha)
                .dataCadastro(LocalDateTime.now())
                .build();

        Paciente salvo = repository.save(paciente);

        return mapToResponse(salvo);
    }

    public List<PacienteResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private PacienteResponse mapToResponse(Paciente paciente) {
        PacienteResponse response = new PacienteResponse();
        response.setId(paciente.getId()); // mapeie o id aqui
        response.setNome(paciente.getNome());
        response.setTipoAtendimento(paciente.getTipoAtendimento().name());
        response.setSenha(paciente.getSenha());
        response.setDataCadastro(paciente.getDataCadastro().toString());
        return response;
    }

}
