package com.painel.hospital.dto;

import com.painel.hospital.entity.TipoAtendimento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PacienteRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Tipo de atendimento é obrigatório")
    private TipoAtendimento tipoAtendimento;
}
