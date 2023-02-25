package com.weverson.api.pessoas.service.impl;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
    public void criarPessoaTest(){
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(1l);;
        pessoa.setNome("Test");

        pessoaServiceImpl.criarPessoa(pessoa);

        Optional<Pessoa> consultaPessoa = pessoaRepository.findById(1l);
        assertTrue(consultaPessoa.isPresent());

  
    }

   
    @Test
    public void consultarPessoaPorIdTest(){
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(1l);;
        pessoa.setNome("Test");

        pessoaServiceImpl.criarPessoa(pessoa);

        Pessoa pessoaConsulta = pessoaServiceImpl.consultarPessoaPorId(1l);
        assertEquals("1", String.valueOf(pessoaConsulta.getIdPessoa()));
        assertEquals("Test", pessoaConsulta.getNome());
    

    }

    @Test
    public void EditarPessoaTeste(){
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(1l);;
        pessoa.setNome("Test");

        pessoaServiceImpl.criarPessoa(pessoa);

        Pessoa pessoaEditada = new Pessoa();
        pessoaEditada.setNome("Teste da Silva");

        pessoaServiceImpl.EditarPessoa(pessoaEditada, 1l);


        Pessoa pessoaConsulta = pessoaServiceImpl.consultarPessoaPorId(1l);
        assertEquals("1", String.valueOf(pessoaConsulta.getIdPessoa()));
        assertEquals("Teste da Silva", pessoaConsulta.getNome());

    }

    @Test
    public void criarEnderecoPessoaTest(){
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(1l);;
        pessoa.setNome("Test");
        
        pessoaServiceImpl.criarPessoa(pessoa);

        Endereco endereco = new Endereco();
        endereco.setIdEndereco(1l);
        endereco.setCep("68740000");
        endereco.setCidade("Castanhal");
        endereco.setEnderecoPrincipal(true);
        endereco.setLogradouro("Travessa cinco");

        pessoaServiceImpl.criarEnderecoPessoa(1l, endereco);

        Optional<Endereco> enderecoCriado = enderecoRepository.findById(2l);
        
        assertTrue(enderecoCriado.isPresent());
  
    }
        
    
}
