package com.natanqn.Banco.service;

import com.natanqn.Banco.model.conta.Conta;
import com.natanqn.Banco.model.transferencia.Transferencia;
import com.natanqn.Banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferenciaService {

    @Autowired
    private ContaService contaService;

    @Autowired
    private TransferenciaRepository transferenciaRepository;


    public void transferirValorPara(BigDecimal valor, Long contaDepositante, Long contaCreditada){
        Conta depositante = contaService.acharContaPorId(contaDepositante).get();
        Conta creditada = contaService.acharContaPorId(contaCreditada).get();;
        if(creditada.getEstaAtiva()){
            if(depositante.verificaSaldo(valor)){
                depositante.sacar(valor);
                creditada.depositar(valor);
            }
            transferenciaRepository.save(new Transferencia(valor, depositante, creditada));
        } else {
            System.out.println("NÃO PODE TRANSFERIR PARA CONTA INATIVA");
        }
        }

    public Iterable<Transferencia> acharTodasAsTransferencias() {
        return transferenciaRepository.findAll();
    }
}



