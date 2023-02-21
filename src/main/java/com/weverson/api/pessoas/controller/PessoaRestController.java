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

import com.weverson.api.pessoas.model.Pessoa;
import com.weverson.api.pessoas.service.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaRestController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Iterable<Pessoa>> buscarTodos(){
        return ResponseEntity.ok(pessoaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa){
        pessoaService.criarPessoa(pessoa);
        return ResponseEntity.ok(pessoa);
    }
    @PutMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> EditarPessoa(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa){
        pessoaService.EditarPessoa(pessoa, idPessoa);
        return ResponseEntity.ok(pessoa);
    }
  

   
    
}
