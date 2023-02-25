package com.weverson.api.pessoas.handler;

public class idNaoEncontradoException extends BusinessException{

    public idNaoEncontradoException(Long id, String campo) {
        super("O id "+id +" do campo " + campo + " não foi encontrado" );
    }
    
}
