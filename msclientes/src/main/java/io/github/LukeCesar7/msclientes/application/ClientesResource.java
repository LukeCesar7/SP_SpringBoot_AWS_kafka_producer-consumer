package io.github.LukeCesar7.msclientes.application;

import io.github.LukeCesar7.msclientes.application.representation.ClienteSaveRequest;
import io.github.LukeCesar7.msclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
@Slf4j
public class ClientesResource {

    private final ClienteService service;

    @GetMapping
    public String status() {
        log.info("Obtendo o status do microservice de clientes");
        return "OK";
    }

    @PostMapping
    public ResponseEntity save (@RequestBody ClienteSaveRequest request) {
        Cliente cliente = request.toModel();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}").
                buildAndExpand(cliente.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente (@RequestParam("cpf") String cpf) {
        var cliente = service.getByCPF(cpf);
            if(cliente.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(cliente);
        }
    }

