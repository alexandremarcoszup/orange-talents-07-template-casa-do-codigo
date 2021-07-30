package br.com.orangetalents.cadadocodigo.controller;

import br.com.orangetalents.cadadocodigo.controller.request.ClienteRequest;
import br.com.orangetalents.cadadocodigo.controller.response.ClienteResponse;
import br.com.orangetalents.cadadocodigo.domain.entity.Cliente;
import br.com.orangetalents.cadadocodigo.domain.repository.ClienteRepository;
import br.com.orangetalents.cadadocodigo.domain.repository.EstadoRepository;
import br.com.orangetalents.cadadocodigo.domain.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastroCliente(@RequestBody @Valid ClienteRequest clienteRequest){

        Cliente cliente = clienteRepository.save(clienteRequest.requestToDomain(paisRepository, estadoRepository));

        return ResponseEntity.ok(cliente.domainToResponse());
    }
}
