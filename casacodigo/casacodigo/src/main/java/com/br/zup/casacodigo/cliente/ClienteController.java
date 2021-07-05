package com.br.zup.casacodigo.cliente;

import com.br.zup.casacodigo.pais.Pais;
import com.br.zup.casacodigo.pais.PaisRepository;
import com.br.zup.casacodigo.pais.estado.Estado;
import com.br.zup.casacodigo.pais.estado.EstadoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    PaisRepository paisRepository;


    @PostMapping
    public ResponseEntity<Cliente> cadastrar (@RequestBody @Valid ClienteRequest clienteRequest){
        Cliente cliente = clienteRequest.converter(paisRepository, estadoRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }
}

