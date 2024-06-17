package com.natanqn.Banco.model.transferencia;

import com.natanqn.Banco.model.conta.Conta;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "transferencias")
public class Transferencia {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private BigDecimal valor;
        @ManyToOne
        private Conta contaPagadora;
        @ManyToOne
        private Conta contaDestino;
        private LocalDateTime horaDaTransferencia;

    public Transferencia() {
    }

    public Transferencia(BigDecimal valor, Conta depositante, Conta creditada) {
        this.id = id;
        this.valor = valor;
        this.contaPagadora = depositante;
        this.contaDestino = creditada;
        this.horaDaTransferencia = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public LocalDateTime getHoraDaTransferencia() {
        return horaDaTransferencia;
    }

    public Conta getContaPagadora() {
        return contaPagadora;
    }
}
