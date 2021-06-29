package com.br.zup.casacodigo;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {
    @NotBlank
    private String nome;
    @NotBlank @Size(max = 400)
    private String descricao;
    @NotBlank(message = "Não pode nulo") @Email(message =  "Email tipo invalido")
    private String email;


    public AutorRequest(@NotBlank String nome, @NotBlank @Size(max = 400) String descricao, @NotBlank @Email String email) {
        this.nome = nome;
        this.descricao = descricao;
        this.email = email;
    }

    public Autor toModel(){
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getEmail() {
        return email;
    }
}
