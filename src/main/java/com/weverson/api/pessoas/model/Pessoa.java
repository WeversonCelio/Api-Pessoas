package com.weverson.api.pessoas.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdPessoa;
    private String nome;
    private Date dataNascimento;

   
    @OneToMany
	private List<Endereco> enderecos;


    public Long getIdPessoa() {
        return IdPessoa;
    }


    public void setIdPessoa(Long idPessoa) {
        IdPessoa = idPessoa;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public Date getDataNascimento() {
        return dataNascimento;
    }


    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public List<Endereco> getEnderecos() {
        return enderecos;
    }


    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    



}
