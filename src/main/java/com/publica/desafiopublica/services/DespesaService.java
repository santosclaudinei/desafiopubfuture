package com.publica.desafiopublica.services;

import com.publica.desafiopublica.exceptions.EntidadeNaoEncontradaException;
import com.publica.desafiopublica.models.Despesa;
import com.publica.desafiopublica.repository.DespesaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa salvaDespesa(@RequestBody Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    public Despesa listaDespesaPorId(long id) {
        var despesaEncontrada = despesaRepository.findById(id);
        if(despesaEncontrada == null) {
            throw  new EntidadeNaoEncontradaException(String.format("Despesa de código %d não encontrada.", id));
        }
        return despesaEncontrada;
    }

    public List<Despesa> listaDespesaPorData() {
        return despesaRepository.findAll(Sort.by(Sort.Direction.ASC, "dataPagamento"));
    }

    public List<Despesa> listaDespesaPorTipo() {
        return despesaRepository.findAll(Sort.by(Sort.Direction.ASC, "tipoDespesa"));
    }

    public Double exibeDespesaTotal( ) {
        return despesaRepository.valorTotalDespesas();
    }

    public Despesa atualizaDespesa(Long id, Despesa despesa) {
        var despesaEncontrada = listaDespesaPorId(id);
        BeanUtils.copyProperties(despesa, despesaEncontrada, "id");
        return despesaRepository.save(despesaEncontrada);
    }

    public void deletaDespesa(Long id) {

        try {
            despesaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Despesa de código %d não encontrada.", id));
        }

    }

}
