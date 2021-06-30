package com.br.zup.casacodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    CategoriaRepository repository;
    @Autowired
    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Categoria> categoriaCadastrar(@RequestBody @Valid CategoriaDTO categoriaDTO){
       Categoria categoria = categoriaDTO.converter();
        return  ResponseEntity.ok(categoria);
    }


}
