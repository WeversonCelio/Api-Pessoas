package com.weverson.api.pessoas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdPessoa;
    private String nome;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataNascimento;

   
    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	// @JsonManagedReference	
	// private List<Endereco> enderecoList;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    

    public Long getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        IdPessoa = idPessoa;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

   


}
