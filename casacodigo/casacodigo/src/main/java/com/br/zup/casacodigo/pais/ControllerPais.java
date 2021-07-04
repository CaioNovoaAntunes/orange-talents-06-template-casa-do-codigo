package com.br.zup.casacodigo.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class ControllerPais {
    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<Pais> salvarPais(@RequestBody @Valid PaisRequest paisRequest){
        Pais pais = paisRequest.toModelo();
        paisRepository.save(pais);
        return ResponseEntity.ok().body(pais);

    }
}
