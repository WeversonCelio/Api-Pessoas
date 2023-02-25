package com.weverson.api.pessoas.service.impl;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weverson.api.pessoas.handler.CamposObrigatorioException;
import com.weverson.api.pessoas.handler.idNaoEncontradoException;
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
        if (pessoa.getNome() == null) {
            throw new CamposObrigatorioException("NOME");

        } else if (pessoa.getDataNascimento() == null) {
            throw new CamposObrigatorioException("DATA DE NASCIMENTO");

        } else {
            pessoaRepository.save(pessoa);
        }
    }

    @Override
    public void EditarPessoa(Pessoa pessoa, Long idPessoa) {
        Optional<Pessoa> pessoaBd = pessoaRepository.findById(idPessoa);
        if (pessoaBd.isPresent()) {
            pessoa.setIdPessoa(idPessoa);
            pessoaRepository.save(pessoa);
        } else {
            throw new idNaoEncontradoException(idPessoa, "idPessoa");
        }

    }

    @Override
    public Iterable<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa consultarPessoaPorId(Long idPessoa) {
        Optional<Pessoa> pessoaBd = pessoaRepository.findById(idPessoa);
        if (pessoaBd.isPresent()) {
            return pessoaBd.get();
        }
        throw new idNaoEncontradoException(idPessoa, "idPessoa");
    }

    @Override
    public void criarEnderecoPessoa(Long idPessoa, Endereco endereco) {
        if (endereco.getCep() == null) {
            throw new CamposObrigatorioException("CEP");
        } else if (endereco.getCidade() == null) {
            throw new CamposObrigatorioException("CIDADE");
        } else if (endereco.getLogradouro() == null) {
            throw new CamposObrigatorioException("LOGRADOURO");
        } else if (endereco.getNumero() == null) {
            throw new CamposObrigatorioException("NUMERO");
        } else {
            Pessoa pessoa = consultarPessoaPorId(idPessoa);
            endereco.setPessoa(pessoa);
            enderecoRepository.save(endereco);
        }

    }

    @Override
    public Iterable<Endereco> listarEnderecoPessoa(Long idPessoa) {
        Pessoa pessoa = consultarPessoaPorId(idPessoa);
        Iterable<Endereco> enderecos = enderecoRepository.findByPessoa(pessoa);
        return enderecos;

    }

    @Override
    public void alterarEnderecoPrincipal(Long idPessoa, Long idEndereco) {
        Iterable<Endereco> listarEnderecoPessoa = listarEnderecoPessoa(idPessoa);

        if (proprietariaEndereco(idEndereco, listarEnderecoPessoa)) {
            for (Endereco e : listarEnderecoPessoa) {
                if (e.getIdEndereco().longValue() == idEndereco) {
                    e.setEnderecoPrincipal(true);
                    enderecoRepository.save(e);
                } else if (e.getEnderecoPrincipal().booleanValue() == true) {
                    e.setEnderecoPrincipal(false);
                    enderecoRepository.save(e);
                }
            }
        } else {
            throw new idNaoEncontradoException(idEndereco, "idEndereco");
        }

    }

    private boolean proprietariaEndereco(Long idEndereco, Iterable<Endereco> listarEnderecoPessoa) {
        Iterator<Endereco> iterator = listarEnderecoPessoa.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getIdEndereco() == idEndereco) {
                return true;
            }
        }
        return false;
    }

}
