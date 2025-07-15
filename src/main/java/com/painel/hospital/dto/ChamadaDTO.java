package com.painel.hospital.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChamadaDTO {
    private String nomePaciente;
    private String senhaPaciente;
    private String consultorio;
    private String nomeMedico;
    private String especialidadeMedica;

    private LocalDateTime horario;
}
