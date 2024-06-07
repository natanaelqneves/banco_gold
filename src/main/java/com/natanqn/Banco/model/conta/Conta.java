package com.natanqn.Banco.model.conta;

import com.natanqn.Banco.model.cliente.Cliente;
import jakarta.persistence.*;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String agencia;
        private Long saldo;
    @OneToOne
    private Cliente titular;
    private Boolean estaAtiva;

    public Conta() {
    }

    public Conta(Cliente cliente) {
        this.id = id;
        this.agencia = "001";
        this.saldo = 0l;
        this.titular = cliente;
        this.estaAtiva = Boolean.TRUE;
        System.out.println("conta criada!");
    }

    public Long getId() {
        return id;
    }

    public String getAgencia() {
        return agencia;
    }



    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public Boolean getEstaAtiva() {
        return estaAtiva;
    }

    public void depositar(Long valor){
        this.saldo = saldo + valor;
    }

    public void sacar(Long valor){
        Boolean haSaldo = verificaSaldo(valor);
        if(haSaldo){
            this.saldo = saldo - valor;
        }
        System.out.println(mensagem(haSaldo));;
    }

    private boolean verificaSaldo(Long valor) {
        return valor <= this.saldo;
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
