package com.weverson.api.pessoas.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.weverson.api.pessoas.handler.CamposObrigatorioException;
import com.weverson.api.pessoas.handler.idNaoEncontradoException;
import com.weverson.api.pessoas.model.Endereco;
import com.weverson.api.pessoas.model.EnderecoRepository;
import com.weverson.api.pessoas.model.Pessoa;
import com.weverson.api.pessoas.model.PessoaRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PessoaServiceImplTest {
    @Autowired
    private PessoaServiceImpl pessoaServiceImpl;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Test
    public void criarPessoaTest() {
        Pessoa pessoa = instanciarPessoa();

        pessoaServiceImpl.criarPessoa(pessoa);

        Optional<Pessoa> consultaPessoa = pessoaRepository.findById(1l);
        assertTrue(consultaPessoa.isPresent());

    }

    @Test
    public void consultarPessoaPorIdTest() {
        Pessoa pessoa = instanciarPessoa();

        pessoaServiceImpl.criarPessoa(pessoa);

        Pessoa pessoaConsulta = pessoaServiceImpl.consultarPessoaPorId(1l);
        assertEquals("1", String.valueOf(pessoaConsulta.getIdPessoa()));
        assertEquals("Test", pessoaConsulta.getNome());

    }

    @Test
    public void EditarPessoaTeste() {
        Pessoa pessoa = instanciarPessoa();
        pessoaServiceImpl.criarPessoa(pessoa);

        Pessoa pessoaEditada = new Pessoa();
        pessoaEditada.setNome("Teste da Silva");
        pessoaEditada.setDataNascimento(LocalDate.of(2000, 01, 20));
        // pessoaEditada

        pessoaServiceImpl.EditarPessoa(pessoaEditada, 1l);

        Pessoa pessoaConsulta = pessoaServiceImpl.consultarPessoaPorId(1l);
        assertEquals("Teste da Silva", pessoaConsulta.getNome());
        assertEquals("2000-01-20", String.valueOf(pessoaConsulta.getDataNascimento()));

    }

    @Test
    public void criarEnderecoPessoaTest() {

        Pessoa pessoa = instanciarPessoa();
        pessoaServiceImpl.criarPessoa(pessoa);

        Endereco endereco = instanciarEndereco();
        pessoaServiceImpl.criarEnderecoPessoa(1l, endereco);

        Optional<Endereco> enderecoCriado = enderecoRepository.findById(2l);

        assertTrue(enderecoCriado.isPresent());

    }

    @Test(expected = CamposObrigatorioException.class)
    public void CamposObrigatorioExceptionCriarPessoaTest() {
        Pessoa pessoaFalha = new Pessoa();
        pessoaFalha.setNome("Maria");
        pessoaServiceImpl.criarPessoa(pessoaFalha);
    }

    @Test(expected = CamposObrigatorioException.class)
    public void CamposObrigatorioExceptionCriarEnderecoPessoaTest() {
        Pessoa pessoa = instanciarPessoa();
        pessoaServiceImpl.criarPessoa(pessoa);

        Endereco enderecoFalha = new Endereco();
        enderecoFalha.setCep("68753000");
        pessoaServiceImpl.criarEnderecoPessoa(1l, enderecoFalha);
    }

    @Test(expected = idNaoEncontradoException.class)
    public void idNaoEncontradoExceptionCriarEnderecoPessoaTest() {
        Pessoa pessoa = instanciarPessoa();
        pessoaServiceImpl.criarPessoa(pessoa);

        Endereco endereco = instanciarEndereco();
        pessoaServiceImpl.criarEnderecoPessoa(2l, endereco);
    }

    // metodos instanciar objetos
    private Endereco instanciarEndereco() {
        Endereco endereco = new Endereco();
        endereco.setIdEndereco(1l);
        endereco.setCep("68740000");
        endereco.setCidade("Castanhal");
        endereco.setEnderecoPrincipal(true);
        endereco.setLogradouro("Travessa cinco");
        endereco.setNumero(1);
        return endereco;
    }

    private Pessoa instanciarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(1l);
        ;
        pessoa.setNome("Test");
        pessoa.setDataNascimento(LocalDate.of(2000, 01, 20));

        return pessoa;

    }

}
