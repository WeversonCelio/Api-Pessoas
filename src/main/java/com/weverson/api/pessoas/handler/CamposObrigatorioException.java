package com.weverson.api.pessoas.handler;

public class CamposObrigatorioException extends BusinessException {

    public CamposObrigatorioException(String campo) {
        super("O campo e obrigatorio: " + campo);
        //TODO Auto-generated constructor stub
    }
    
}
