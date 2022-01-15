package com.publica.desafiopublica.repository;

import com.publica.desafiopublica.models.Conta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Long> {

    Conta findById(long id);

    @Query(value = "SELECT sum(c.valor) FROM TB_CONTAS c ", nativeQuery = true)
    Double valorTotalContas();

}
