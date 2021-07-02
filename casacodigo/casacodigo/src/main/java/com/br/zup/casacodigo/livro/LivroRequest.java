package com.br.zup.casacodigo.livro;


import com.br.zup.casacodigo.autor.Autor;
import com.br.zup.casacodigo.categoria.Categoria;
import com.br.zup.casacodigo.validation.CheckIfExist;
import com.br.zup.casacodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroRequest {
    @NotBlank
    @UniqueValue(instanceClass = Livro.class, field = "titulo")
    @JsonProperty
    private String titulo;

    @NotBlank
    @JsonProperty
    private String sumario;

    @NotBlank
    @JsonProperty
    @Size(max = 500)
    private String resumo;

    @Min(value = 20)
    @NotNull
    @JsonProperty
    private BigDecimal preco;

    @Min(value = 100)
    @NotNull
    @JsonProperty
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(instanceClass = Livro.class , field = "isbn")
    @JsonProperty
    private String isbn;


    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;

    @JsonProperty
    @CheckIfExist(identityField = "id", instanceClass = Categoria.class)
    private Long categoria;

    @JsonProperty
    @CheckIfExist(identityField = "id"  , instanceClass = Autor.class)
    private Long autor;



    public LivroRequest(@NotBlank String titulo, @NotBlank String sumario, @NotBlank @Size(max = 500) String resumo, @Min(value = 20) @NotNull BigDecimal preco, @Min(value = 100) @NotNull Integer numeroPaginas, @NotBlank String isbn, @Future LocalDate dataLancamento, @Valid Long categoria, @Valid Long autor) {
        this.titulo = titulo;
        this.sumario = sumario;
        this.resumo = resumo;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }
    public Livro toModel(EntityManager entityManager){
     Autor a =   entityManager.find(Autor.class, autor);
       Categoria c = entityManager.find(Categoria.class, categoria);

        return new Livro(titulo,sumario,resumo,preco,numeroPaginas,isbn,dataLancamento, c, a );
    }



    public String getTitulo() {
        return titulo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getResumo() {
        return resumo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Long getCategoria() {
        return categoria;
    }

    public Long getAutor() {
        return autor;
    }
}