package com.publica.desafiopublica.repository;

import com.publica.desafiopublica.models.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    Despesa findById(long id);

    @Query(value = "SELECT sum(c.valor) FROM TB_DESPESAS c ", nativeQuery = true)
    Double valorTotalDespesas();

}
