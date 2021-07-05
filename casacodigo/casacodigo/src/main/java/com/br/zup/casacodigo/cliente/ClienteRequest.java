package com.br.zup.casacodigo.cliente;

import com.br.zup.casacodigo.pais.Pais;
import com.br.zup.casacodigo.pais.PaisRepository;
import com.br.zup.casacodigo.pais.estado.Estado;
import com.br.zup.casacodigo.pais.estado.EstadoRepository;
import com.br.zup.casacodigo.validation.CheckIfExist;
import com.br.zup.casacodigo.validation.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteRequest {
    @NotBlank
    @UniqueValue(instanceClass = Cliente.class, field = "email")
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @UniqueValue(instanceClass = Cliente.class, field = "documento")
    private String documento;
    @NotNull
    @NotEmpty
    private String endereco;
    @NotNull
    @NotEmpty
    private String complemento;
    @NotNull
    @NotEmpty
    private String cidade;
    @NotNull
    @CheckIfExist(instanceClass = Pais.class, identityField = "id")
    private Long pais;
    @CheckIfExist(instanceClass = Estado.class, identityField = "id")
    private Long estado;
    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    @NotEmpty
    private String cep;



   public ClienteRequest(){

   }

    public ClienteRequest( @NotNull @NotEmpty @Email String email,
                           @NotNull @NotEmpty String nome,
                           @NotNull @NotEmpty String sobrenome,
                           @NotNull @NotEmpty String documento,
                           @NotNull @NotEmpty String endereco, String complemento,
                           @NotNull @NotEmpty String cidade,
                           @NotNull Long pais,
                           Long estado,
                           @NotNull @NotEmpty String telefone,
                           @NotNull @NotEmpty String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }



    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Optional<Pais> pais = paisRepository.findById(this.pais);
        Estado estadoInstance = null;
        if(this.estado != null){
            estadoInstance = estadoRepository.findById(this.estado).get();
        }
        return new Cliente(this.email,
                this.nome,
                this.sobrenome,
                this.documento,
                this.endereco,
                this.complemento,
                this.cidade,
                pais.get(),
                estadoInstance,
                this.telefone,
                this.cep);
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "ClienteRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + pais +
                ", estado=" + estado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}