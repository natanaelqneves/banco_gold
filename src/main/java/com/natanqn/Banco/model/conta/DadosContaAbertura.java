package com.natanqn.Banco.model.conta;

import com.natanqn.Banco.model.cliente.DadosClienteCadastro;

import java.math.BigDecimal;

public record DadosContaAbertura (String nome,
                                  String cpf,
                                  String email,
                                  String login,
                                  String senha){
}
