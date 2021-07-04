package com.br.zup.casacodigo.pais.estado;

import com.br.zup.casacodigo.pais.Pais;

import javax.persistence.*;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    private Pais pais;

    public Estado(){

    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
    public String getNome(){
        return nome;
    }

    public Long getId() {
        return id;
    }

    public Pais getPais() {
        return pais;
    }
}
