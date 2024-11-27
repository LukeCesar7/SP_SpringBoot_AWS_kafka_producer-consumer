package io.github.lukecesar7.mscartoes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao(String nome, BigDecimal renda, BandeiraCartao bandeira, BigDecimal limiteBasico) {
        this.nome = nome;
        this.renda = renda;
        this.bandeira = bandeira;
        this.limiteBasico = limiteBasico;
    }
}
