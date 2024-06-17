package com.natanqn.Banco.model.conta;

import com.natanqn.Banco.model.cliente.Cliente;
import jakarta.persistence.*;

import java.math.BigDecimal;

import static java.lang.Boolean.*;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String agencia;
        private BigDecimal saldo;
    @OneToOne
    private Cliente titular;
    private Boolean estaAtiva;

    public Conta() {
    }

    public Conta(Cliente cliente) {
        this.id = id;
        this.agencia = "001";
        this.saldo = BigDecimal.ZERO;
        this.titular = cliente;
        this.estaAtiva = TRUE;
        System.out.println("conta criada!");
    }

    public Long getId() {
        return id;
    }

    public String getAgencia() {
        return agencia;
    }



    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public Boolean getEstaAtiva() {
        return estaAtiva;
    }


    public void depositar(BigDecimal valor){
        this.saldo = saldo.add(valor);
    }

    public void sacar(BigDecimal valor){
        Boolean haSaldo = verificaSaldo(valor);
        if(haSaldo){
            this.saldo = saldo.subtract(valor);
        }
        System.out.println(mensagem(haSaldo));
    }

    public boolean verificaSaldo(BigDecimal valor) {
        if(this.saldo.compareTo(valor) >= 0){
            return true;
        }
        return false;
    }

    private String mensagem(Boolean estaAtiva) {
        return estaAtiva ? "REALIZADA" : "NÃO REALIZADA";
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agência='" + agencia + '\'' +
                ", saldo=" + saldo +
                ", titular=" + titular.getNome() +
                '}';
    }


}
