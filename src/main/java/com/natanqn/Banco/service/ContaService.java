package com.natanqn.Banco.service;

import com.natanqn.Banco.model.cliente.Cliente;
import com.natanqn.Banco.model.conta.Conta;
import com.natanqn.Banco.model.conta.DadosContaAbertura;
import com.natanqn.Banco.repository.ClienteRepository;
import com.natanqn.Banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    public void salvarNovaConta(DadosContaAbertura dados) {
        Cliente cliente = new Cliente(dados);
        clienteRepository.save(cliente);
        contaRepository.save(new Conta(cliente));
    }
/*
    public Conta acharContaPorEmail(String email) {
        return contaRepository.findByEmail(email);
    }
*/
    public Optional<Conta> acharContaPorId(Long id) {
        return contaRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        contaRepository.deleteById(id);
    }

    public void depositar(Long valor, Long id){
        Optional<Conta> conta = acharContaPorId(id);
        conta.get().depositar(valor);
    }

    public void sacar(Long valor, Long id){
        Optional<Conta> conta = acharContaPorId(id);
        conta.get().sacar(valor);
    }

    public Iterable<Conta> acharTodasAsContas() {
        return contaRepository.findAll();
    }
}
