package com.br.zup.casacodigo.livro;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {


    @PostMapping
    public String cadastraLivro(@RequestBody @Valid LivroRequest livroRequest){
        return "irei salvar um livro";
    }
}
