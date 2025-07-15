package com.painel.hospital.exception;

public class TipoInvalidoException extends RuntimeException{
    public TipoInvalidoException(String tipo) {
        super("Tipo de atendimento inválido: "+ tipo);
    }
}
