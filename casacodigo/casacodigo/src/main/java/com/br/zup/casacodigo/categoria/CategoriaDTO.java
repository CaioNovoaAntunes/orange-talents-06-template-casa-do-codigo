package com.br.zup.casacodigo.categoria;

import com.br.zup.casacodigo.validation.UniqueValue;


public class CategoriaDTO {

    @UniqueValue(instanceClass = Categoria.class, field = "nome")
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(String nome) {
        this.nome = nome;
    }

    public Categoria converter(){
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}

