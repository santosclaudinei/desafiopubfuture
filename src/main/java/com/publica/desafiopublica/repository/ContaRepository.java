package com.publica.desafiopublica.repository;

import com.publica.desafiopublica.models.Conta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Long> {

    Conta findById(long id);

    Conta findByNumeroConta(String numeroConta);

    @Query(value = "SELECT sum(C.saldo) FROM TB_CONTAS C ", nativeQuery = true)
    Double valorTotalContas();

}
