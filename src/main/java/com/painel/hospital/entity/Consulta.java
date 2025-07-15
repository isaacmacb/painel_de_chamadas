package com.painel.hospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;


    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;


    @ManyToOne
    @JoinColumn(name = "consultorio_id")  // opcional, para definir nome da FK
    private Consultorio consultorio;

    private LocalDateTime horario;

}
