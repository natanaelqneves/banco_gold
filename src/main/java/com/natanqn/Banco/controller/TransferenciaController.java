package com.natanqn.Banco.controller;

import com.natanqn.Banco.model.transferencia.Transferencia;
import com.natanqn.Banco.service.TransferenciaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transacao")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @Transactional
    @PostMapping
    public void transferirDePara(BigDecimal valor, Long depositante, Long creditada ){
        System.out.println("TENTOU TRANSFERIR!");
        transferenciaService.transferirValorPara(valor, depositante, creditada);
    }

    @GetMapping
    public Iterable<Transferencia> acharTodasAsTransferencias(){
        return transferenciaService.acharTodasAsTransferencias();
    }
}
