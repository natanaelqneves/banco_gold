package com.natanqn.Banco.model.cliente;

public record DadosClienteCadastro(String nome,
                                   String cpf,
                                   String email,
                                   String login,
                                   String senha) {
}
