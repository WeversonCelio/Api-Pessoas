package com.weverson.api.pessoas.service;

import com.weverson.api.pessoas.model.Endereco;
import com.weverson.api.pessoas.model.Pessoa;

public interface PessoaService {
    /**
     * Metodo para criacao de pessoa no banco
     * 
     * @param pessoa pessoa para ser adicionada
     */
    void criarPessoa(Pessoa pessoa);

    /**
     * Metodo para editar as pessoas no banco
     * 
     * @param pessoa   novos valores da pessoa a ser editada
     * @param idPessoa id da pessoa a ser editada
     */
    void EditarPessoa(Pessoa pessoa, Long idPessoa);

    /**
     * Metodo para retornar uma pessoa pelo seu Id
     * 
     * @param idPessoa id da pessoa a ser consultada
     * @return retorna uma <code>Pessoa</code>
     */
    Pessoa consultarPessoaPorId(Long idPessoa);

    /**
     * Lista todas as pessoas no banco
     * 
     * @return retorna um <code>Iterable<Pessoa></code>
     */
    Iterable<Pessoa> buscarTodos();

    /**
     * Metodo para criacao de endereco de uma pessoa
     * 
     * @param idPessoa id da pessoa dona do endereco
     * @param endereco endereco a ser criado
     */
    void criarEnderecoPessoa(Long idPessoa, Endereco endereco);

    /**
     * Lista todos os endereco de uma pessoa
     * 
     * @param idPessoa id da pessoa dona do endereco
     * @return retorna um <code>Iterable<Endereco></code>
     */
    Iterable<Endereco> listarEnderecoPessoa(Long idPessoa);

    /**
     * Metodo para alterar o endereco principal de uma pessoa
     * 
     * @param idPessoa   id da pessoa que tera seu endereco alterado
     * @param idEndereco id do novo endereco principal
     */
    void alterarEnderecoPrincipal(Long idPessoa, Long idEndereco);

}
