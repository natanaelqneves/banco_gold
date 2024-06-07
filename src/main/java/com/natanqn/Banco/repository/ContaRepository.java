package com.natanqn.Banco.repository;

import com.natanqn.Banco.model.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    //Conta findByEmail(String email);
}
