package com.weverson.api.pessoas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdPessoa;
    private String nome;
    private Date dataNascimento;



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



}
