package com.br.zup.casacodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @PersistenceContext
    EntityManager entityManager;

   private LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public ResponseEntity<?> listarLivros() {
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(livros.stream().map(LivroResponse::new).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetalharLivroDTO> listarLivros(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if(!livro.isPresent()){
            return ResponseEntity.notFound().build();
        }
        DetalharLivroDTO dto = new DetalharLivroDTO(livro.get());
        return ResponseEntity.ok(dto);
    }



    @PostMapping
    public Livro cadastraLivro(@RequestBody @Valid LivroRequest livroRequest){
        Livro livro = livroRequest.toModel(entityManager);
        return livroRepository.save(livro);
    }
}
