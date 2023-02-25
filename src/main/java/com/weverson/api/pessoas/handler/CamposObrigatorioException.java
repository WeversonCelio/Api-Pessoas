package com.weverson.api.pessoas.handler;

public class CamposObrigatorioException extends BusinessException {

    /**
     * Retorna uma excecao caso um dos campos obrigatorio nao seja preenchido
     * 
     * @param campo nome do campo ausente
     */
    public CamposObrigatorioException(String campo) {
        super("O campo e obrigatorio: " + campo);

    }

}
