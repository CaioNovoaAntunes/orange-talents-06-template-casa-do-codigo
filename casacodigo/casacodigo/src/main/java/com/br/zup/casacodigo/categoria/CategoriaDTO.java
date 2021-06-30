package com.br.zup.casacodigo.categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaDTO {
    @NotBlank
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(@NotNull @NotEmpty String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}

