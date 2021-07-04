package com.br.zup.casacodigo.pais.estado;

import com.br.zup.casacodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    EstadoRepository repository;

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadosRequestDto dto ) {
        Estado estado = dto.toModel(paisRepository);
        repository.save(estado);
        return ResponseEntity.ok(estado);



    }

}