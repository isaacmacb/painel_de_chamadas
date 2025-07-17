package com.painel.hospital.dto;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = lombok.AccessLevel.PUBLIC) // Construtor público para o builder
@NoArgsConstructor
public class PacienteResponse {

    private Long id;
    private String nome;
    private String senha;
    private String tipoAtendimento;
    private String dataCadastro;

}