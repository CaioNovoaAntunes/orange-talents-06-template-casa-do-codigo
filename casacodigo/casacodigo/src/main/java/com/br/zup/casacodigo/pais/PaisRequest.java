package com.br.zup.casacodigo.pais;

import com.br.zup.casacodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @JsonProperty("nome")
    @UniqueValue(field = "nome", instanceClass = Pais.class)
    private String nome;

    public PaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public PaisRequest() {
    }

    public Pais toModelo() {
        return new Pais(this.nome);
    }

}