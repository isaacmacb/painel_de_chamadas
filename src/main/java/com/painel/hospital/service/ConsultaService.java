package com.painel.hospital.service;

import com.painel.hospital.dto.ChamadaDTO;
import com.painel.hospital.entity.Consulta;
import com.painel.hospital.repository.ConsultaRepository;
import com.painel.hospital.repository.ConsultorioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {
    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public List<ChamadaDTO> listarChamadasDoDia() {
        LocalDateTime inicio = LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime fim = inicio.plusDays(1).minusNanos(1);

        List<Consulta> consultas = repository.findByHorarioBetween (inicio, fim);

        return consultas.stream().map(consulta -> {
            ChamadaDTO dto = new ChamadaDTO();
            dto.setNomePaciente(consulta.getPaciente().getNome());
            dto.setSenhaPaciente(consulta.getPaciente().getSenha());
            dto.setConsultorio(consulta.getConsultorio().getNome());
            dto.setNomeMedico(consulta.getMedico().getNome());
            dto.setEspecialidadeMedica(consulta.getMedico().getEspecialidade());
            dto.setHorario(LocalDateTime.parse(consulta.getHorario().toString())); // ajuste se necessário
            return dto;
        }).collect(Collectors.toList());
    }
}

