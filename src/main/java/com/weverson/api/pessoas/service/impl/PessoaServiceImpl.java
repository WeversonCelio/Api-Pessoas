package com.weverson.api.pessoas.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weverson.api.pessoas.model.Endereco;
import com.weverson.api.pessoas.model.EnderecoRepository;
import com.weverson.api.pessoas.model.Pessoa;
import com.weverson.api.pessoas.model.PessoaRepository;
import com.weverson.api.pessoas.service.PessoaService;



@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
     @Autowired
     private EnderecoRepository enderecoRepository;

    @Override
    public void criarPessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);

    }

    @Override
    public void EditarPessoa(Pessoa pessoa, Long idPessoa) {
        Optional<Pessoa> pessoaBd = pessoaRepository.findById(idPessoa);
        if (pessoaBd.isPresent()) {
            pessoa.setIdPessoa(idPessoa);
            pessoaRepository.save(pessoa);
        }

    }


    @Override
    public Iterable<Pessoa> buscarTodos() {

        return pessoaRepository.findAll();
    }

    
    @Override
    public Pessoa consultarPessoaPorId(Long idPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
        return pessoa;
    }


    @Override
    public void criarEnderecoPessoa(Long idPessoa, Endereco endereco) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
        endereco.setPessoa(pessoa);
        enderecoRepository.save(endereco);

    }

    @Override
    public Iterable<Endereco> listarEnderecoPessoa(Long idPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
    Iterable<Endereco> enderecos = enderecoRepository.findByPessoa(pessoa);
      return enderecos;

    }

    @Override
    public void alterarEnderecoPrincipal(Long idPessoa, Long idEndereco) {
        Iterable<Endereco> listarEnderecoPessoa = listarEnderecoPessoa( idPessoa);
        for (Endereco e : listarEnderecoPessoa) {
            if(e.getEnderecoPrincipal().booleanValue()==true){
                e.setEnderecoPrincipal(false);
                enderecoRepository.save(e);

            }
            if(e.getIdEndereco().longValue()==idEndereco){
                e.setEnderecoPrincipal(true);
                enderecoRepository.save(e);
            }  
        }

        



    }

}
