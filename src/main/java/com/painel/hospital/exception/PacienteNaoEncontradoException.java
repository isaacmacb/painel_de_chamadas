package com.painel.hospital.exception;

public class PacienteNaoEncontradoException extends RuntimeException{
    public PacienteNaoEncontradoException(Long id) {
        super("Paciente não encontrado com id: " + id);
    }
}
