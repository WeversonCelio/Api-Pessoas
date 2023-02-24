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

// * Criar uma pessoa
// * Editar uma pessoa
// * Consultar uma pessoa
// * Listar pessoas
// * Criar endereço para pessoa
// * Listar endereços da pessoa
// * Poder informar qual endereço é o principal da pessoa  

@RestController
@RequestMapping("pessoas")
public class PessoaRestController {

    @Autowired
    private PessoaService pessoaService;

    // public void criarPessoa(Pessoa pessoa) {
    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.criarPessoa(pessoa);
        return ResponseEntity.ok(pessoa);
    }

    // public void EditarPessoa(Pessoa pessoa, Long idPessoa) {
    @PutMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> EditarPessoa(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa) {
        pessoaService.EditarPessoa(pessoa, idPessoa);
        return ResponseEntity.ok(pessoa);
    }

    // public Iterable<Pessoa> buscarTodos()
    @GetMapping
    public ResponseEntity<Iterable<Pessoa>> buscarTodos() {
        return ResponseEntity.ok(pessoaService.buscarTodos());
    }

    // public Pessoa consultarPessoaPorId(Long idPessoa)
    @GetMapping("/id/{idPessoa}")
    public ResponseEntity<Pessoa> consultarPessoaPorId(@PathVariable Long idPessoa) {
        return ResponseEntity.ok(pessoaService.consultarPessoaPorId(idPessoa));
    }

    // public void criarEnderecoPessoa(Long idPessoa, Endereco endereco)
        @PostMapping("endereco/{idPessoa}")
        public ResponseEntity<Endereco> criarEnderecoPessoa(@PathVariable Long idPessoa, @RequestBody Endereco endereco) {
            pessoaService.criarEnderecoPessoa(idPessoa, endereco);
            return ResponseEntity.ok(endereco);
        }

         // public List<Endereco> listarEnderecoPessoa(Long idPessoa)
    @GetMapping("endereco/{idPessoa}")
    public ResponseEntity<Iterable<Endereco>> listarEnderecoPessoa(@PathVariable Long idPessoa) {
        return ResponseEntity.ok(pessoaService.listarEnderecoPessoa(idPessoa));
    }

    /// void alterarEnderecoPrincipal(Long idPessoa, Long idEndereco);
    @PutMapping("endereco/{IdPessoa}/{IdEndereco}")
    public ResponseEntity<Iterable<Endereco>> alterarEnderecoPrincipal(@PathVariable Long IdPessoa, @PathVariable Long IdEndereco){
        pessoaService.alterarEnderecoPrincipal(IdPessoa,IdEndereco );
        return ResponseEntity.ok(pessoaService.listarEnderecoPessoa(IdPessoa));
    } 

   

}
