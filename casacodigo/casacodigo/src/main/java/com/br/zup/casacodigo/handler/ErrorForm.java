package com.br.zup.casacodigo.handler;

public class ErrorForm {
    private String campo;
    private String erro;

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

    public ErrorForm(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}

