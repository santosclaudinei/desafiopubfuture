package com.publica.desafiopublica.repository;

import com.publica.desafiopublica.models.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    Receita findById(long id);

    @Query(value = "SELECT sum(r.valor) FROM TB_RECEITAS r ", nativeQuery = true)
    Double valorTotalReceitas();

}
