package com.br.zup.casacodigo.pais;

import com.br.zup.casacodigo.pais.estado.Estado;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
    public class Pais {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        private String nome;
        @OneToMany(mappedBy = "pais")
         private List<Estado> estados=new ArrayList<>();
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



