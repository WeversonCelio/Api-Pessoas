package com.weverson.api.pessoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weverson.api.pessoas.model.Endereco;
import com.weverson.api.pessoas.model.Pessoa;
import com.weverson.api.pessoas.service.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaRestController {

    @Autowired
    private PessoaService pessoaService;

    // Criar uma pessoa
    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.criarPessoa(pessoa);
        return ResponseEntity.ok(pessoa);
    }

    // Editar uma pessoa
    @PutMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> EditarPessoa(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa) {
        pessoaService.EditarPessoa(pessoa, idPessoa);
        return ResponseEntity.ok(pessoa);
    }

    // Listar pessoas
    @GetMapping
    public ResponseEntity<Iterable<Pessoa>> buscarTodos() {
        return ResponseEntity.ok(pessoaService.buscarTodos());
    }

    // Consultar uma pessoa
    @GetMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> consultarPessoaPorId(@PathVariable Long idPessoa) {
        return ResponseEntity.ok(pessoaService.consultarPessoaPorId(idPessoa));
    }

    // Criar endereço para pessoa
    @PostMapping("endereco/{idPessoa}")
    public ResponseEntity<Endereco> criarEnderecoPessoa(@PathVariable Long idPessoa, @RequestBody Endereco endereco) {
        pessoaService.criarEnderecoPessoa(idPessoa, endereco);
        return ResponseEntity.ok(endereco);
    }

    // Listar endereços da pessoa
    @GetMapping("endereco/{idPessoa}")
    public ResponseEntity<Iterable<Endereco>> listarEnderecoPessoa(@PathVariable Long idPessoa) {
        return ResponseEntity.ok(pessoaService.listarEnderecoPessoa(idPessoa));
    }

    /// informar endereço principal da pessoa
    @PutMapping("endereco/{IdPessoa}/{IdEndereco}")
    public ResponseEntity<Iterable<Endereco>> alterarEnderecoPrincipal(@PathVariable Long IdPessoa,
            @PathVariable Long IdEndereco) {
        pessoaService.alterarEnderecoPrincipal(IdPessoa, IdEndereco);
        return ResponseEntity.ok(pessoaService.listarEnderecoPessoa(IdPessoa));
    }

}
