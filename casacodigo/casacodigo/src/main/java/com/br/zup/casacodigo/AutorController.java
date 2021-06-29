package com.br.zup.casacodigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorRepository autorRepository;


    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorRequest autorRequest , UriComponentsBuilder uriComponentsBuilder){
        Autor autor = autorRequest.toModel();
        Autor aSalvo = autorRepository.save(autor);
        return ResponseEntity.ok().body(new AutorResponse(aSalvo));
    }
}
