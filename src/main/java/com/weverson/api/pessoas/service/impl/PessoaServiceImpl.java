package com.weverson.api.pessoas.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weverson.api.pessoas.model.Endereco;
import com.weverson.api.pessoas.model.Pessoa;
import com.weverson.api.pessoas.model.PessoaRepository;
import com.weverson.api.pessoas.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    // @Autowired
    // private EnderecoRepository enderecoRepository;

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
        return pessoaRepository.findById(idPessoa).get();
    }

    @Override
    public Pessoa consultarPessoaPorNome(String nome) {
        Iterator<Pessoa> iterator = buscarTodos().iterator();
        while (iterator.hasNext()) {
            if ((nome.compareToIgnoreCase(iterator.next().getNome())) == 0) {
                return iterator.next();
            }
        }
        return null;
    }

    @Override
    public void alterarEnderecoPrincipal(Long idPessoa, Long idEndereco) {
       // Optional<Pessoa> pessoaBd = pessoaRepository.findById(idPessoa);

    }

    @Override
    public void criarEnderecoPessoa(Long idPessoa, Endereco endereco) {
        // Pessoa pessoa = consultarPessoaPorId(idPessoa);
        // List<Endereco> listarEnderecoPessoa = listarEnderecoPessoa(idPessoa);
        // listarEnderecoPessoa.add(endereco);
        // pessoa.setEndereco(listarEnderecoPessoa);
        // EditarPessoa(pessoa, idPessoa);
    }

    @Override
    public List<Endereco> listarEnderecoPessoa(Long idPessoa) {
      // Pessoa pessoa = consultarPessoaPorId(idPessoa);
      //  return pessoa.getEndereco();
      return null;

    }

}
