package com.painel.hospital.dto;

import com.painel.hospital.entity.TipoAtendimento;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PacienteDTO {
    private Long id;
    private String nome;
    private TipoAtendimento tipoAtendimento;
    private String senha;
    private String dataCadastro;
}
