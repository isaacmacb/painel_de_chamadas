package com.painel.hospital.repository;

import com.painel.hospital.entity.Paciente;
import com.painel.hospital.entity.TipoAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Long countByTipoAtendimento(TipoAtendimento tipoAtendimento);}
