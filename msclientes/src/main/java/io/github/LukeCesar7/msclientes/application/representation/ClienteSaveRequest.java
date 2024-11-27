package io.github.LukeCesar7.msclientes.application.representation;

import io.github.LukeCesar7.msclientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {

    private String nome;
    private String cpf;
    private Integer idade;

    public Cliente toModel(){
        return new Cliente (cpf, nome, idade);
    }
}
