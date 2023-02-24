package com.weverson.api.pessoas.model;

import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
    Iterable<Endereco> findByPessoa(Pessoa pessoa);
    
}
