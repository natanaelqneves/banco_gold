package com.natanqn.Banco.repository;

import com.natanqn.Banco.model.transferencia.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
