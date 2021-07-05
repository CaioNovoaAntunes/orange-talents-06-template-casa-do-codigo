package com.br.zup.casacodigo.pais.estado;


import com.br.zup.casacodigo.pais.Pais;
import com.br.zup.casacodigo.pais.PaisRepository;
import com.br.zup.casacodigo.validation.CheckIfExist;
import com.br.zup.casacodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadosRequestDto {
    @NotBlank
    @UniqueValue(instanceClass = Estado.class, field = "nome")
    private String nome;

    @NotNull
    @CheckIfExist(identityField = "id", instanceClass = Pais.class)
    @JsonProperty("pais")
    private Long pais;



   

    public EstadosRequestDto(@NotBlank String nome, @NotNull Long pais) {
        this.nome = nome;
        this.pais = pais;
    }


    public Estado toModel(PaisRepository paisRepository) {

        Optional<Pais> pais = paisRepository.findById(this.pais);

        return new Estado(this.nome,  pais.get());
    }
}


