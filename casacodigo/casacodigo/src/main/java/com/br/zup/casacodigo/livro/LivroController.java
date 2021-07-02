package com.br.zup.casacodigo.livro;

import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @PersistenceContext
    EntityManager entityManager;

   private LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }


    @PostMapping
    public Livro cadastraLivro(@RequestBody @Valid LivroRequest livroRequest){
        Livro livro = livroRequest.toModel(entityManager);
        return livroRepository.save(livro);
    }
}
