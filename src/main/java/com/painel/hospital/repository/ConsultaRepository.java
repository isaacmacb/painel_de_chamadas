package com.painel.hospital.repository;

import com.painel.hospital.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByHorarioBetween (LocalDateTime start, LocalDateTime end);
}
