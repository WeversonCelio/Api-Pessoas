package com.weverson.api.pessoas.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Endereco {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdEndereco;

    
    // @ManyToOne(cascade = CascadeType.ALL)
	// private Usuario usuario;


    private String cep;
    private String logradouro;
    private String numero;
    private String cidade;
    private Boolean enderecoPrincipal;

    

    public Boolean getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Boolean enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getIdEndereco() {
        return IdEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        IdEndereco = idEndereco;
    }

}
