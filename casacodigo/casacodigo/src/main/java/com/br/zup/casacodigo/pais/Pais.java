package com.br.zup.casacodigo.pais;

import javax.persistence.*;

@Entity
    public class Pais {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        private String nome;
    public Pais(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Pais() {
    }

    public Pais(Long id) {
        this.id = id;
    }



    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                '}';
    }
}



