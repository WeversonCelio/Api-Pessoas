package com.weverson.api.pessoas.handler;

public class idNaoEncontradoException extends BusinessException {
    /**
     * retorna uma excecao caso nao seja localizado o id
     * 
     * @param id    id do <code>campo</code> nao foi localizado no banco
     * @param campo campo em que o <code> id </code> nao foi localizado
     */
    public idNaoEncontradoException(Long id, String campo) {
        super("O id " + id + " do campo " + campo + " não foi encontrado");
    }

}
