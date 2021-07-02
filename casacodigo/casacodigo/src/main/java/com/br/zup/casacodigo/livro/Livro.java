package com.br.zup.casacodigo.livro;

import com.br.zup.casacodigo.autor.Autor;
import com.br.zup.casacodigo.categoria.Categoria;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String titulo;

    @Lob
    @Column(nullable = false)
    private String sumario;


    @Column(nullable = false,length = 500)
    private String resumo;

    @Column(nullable = false)
    private BigDecimal preco;


    @Column(nullable = false)
    private Integer numeroPaginas;


    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private LocalDate dataLancamento;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    private Autor autor;

    public Livro(String titulo, String sumario, String resumo, BigDecimal preco, Integer numeroPaginas, String isbn, LocalDate dataLancamento, Categoria categoria, Autor autor) {
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
    @Deprecated
    public Livro() {
    }

    public Livro(Long id) {
        this.id=id;
    }

    public Long getId() {
        return id;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }


    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", resumo='" + resumo + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", categoria=" + categoria.getNome() +
                ", autor=" + autor.getNome() +
                '}';
    }
}