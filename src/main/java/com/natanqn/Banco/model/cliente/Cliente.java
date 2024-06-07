package com.natanqn.Banco.model.cliente;

import com.natanqn.Banco.model.conta.Conta;
import com.natanqn.Banco.model.conta.DadosContaAbertura;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;
    @OneToOne
    @Transient
    private Conta conta;
    private LocalDateTime horaDeCadastro;

    public Cliente() {
    }

    public Cliente(DadosContaAbertura dados) {
        this.id = id;
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.login = dados.login();
        this.senha = dados.senha();
        this.horaDeCadastro = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getHoraDeCadastro() {
        return horaDeCadastro;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
