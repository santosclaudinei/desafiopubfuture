package com.publica.desafiopublica.repository;

import com.publica.desafiopublica.models.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Long> {

    Conta findById(long id);

}
