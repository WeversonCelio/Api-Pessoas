package com.weverson.api.pessoas.service;

import com.weverson.api.pessoas.model.Endereco;
import com.weverson.api.pessoas.model.Pessoa;

public interface PessoaService {
// Criar uma pessoa
void criarPessoa(Pessoa pessoa);

// Editar uma pessoa
void EditarPessoa(Pessoa pessoa, Long idPessoa);

// Consultar uma pessoa
Pessoa consultarPessoaPorId(Long idPessoa);
Pessoa consultarPessoaPorNome(String nome);

// Listar pessoas
Iterable<Pessoa> buscarTodos();

// Criar endereço para pessoa
void criarEnderecoPessoa(Long idPessoa, Endereco endereco);
// Listar endereços da pessoa
Iterable<Endereco> listarEnderecoPessoa(Long idPessoa);

// Poder informar qual endereço é o principal da pessoa  
void alterarEnderecoPrincipal(Long idPessoa, Long idEndereco);


}
