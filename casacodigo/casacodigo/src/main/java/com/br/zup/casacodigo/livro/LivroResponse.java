package com.br.zup.casacodigo.livro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroResponse {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "titulo")
    private String titulo;

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}

