package com.br.zup.casacodigo.livro;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> cadastraLivro(@RequestBody @Valid LivroRequest livroRequest){
        Livro livro = livroRequest.toModel(entityManager);
        return ResponseEntity.ok().body(livroRepository.save(livro));
    }
}
