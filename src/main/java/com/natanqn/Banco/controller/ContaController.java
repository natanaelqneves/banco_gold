package com.natanqn.Banco.controller;


import com.natanqn.Banco.model.conta.Conta;
import com.natanqn.Banco.model.conta.DadosContaAbertura;
import com.natanqn.Banco.service.ContaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public void novaConta(DadosContaAbertura dados) {
        contaService.salvarNovaConta(dados);
    }

    @GetMapping
    public Iterable<Conta> acharTodasAsContas(){
        return contaService.acharTodasAsContas();
    }
/*
    @GetMapping(path = "/email/{email}")
    public Conta acharContaPorEmail(@PathVariable String email){
        return contaService.acharContaPorEmail(email);
    }
*/
    @GetMapping(path = "/id/{id}")
    public Optional<Conta> acharContaPorId(@PathVariable Long id){
        return contaService.acharContaPorId(id);
    }

    @Transactional
    @PostMapping(path = "/depositar")
    public void depositar(BigDecimal valor, Long id){
        contaService.depositar(valor, id);
    }

    @Transactional
    @PostMapping(path = "/sacar")
    public void sacar(BigDecimal valor, Long id){
        contaService.sacar(valor, id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(Long id){
        contaService.deletarPorId(id);
    }


}

