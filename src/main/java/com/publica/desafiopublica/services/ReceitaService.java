package com.publica.desafiopublica.services;

import com.publica.desafiopublica.models.Despesa;
import com.publica.desafiopublica.models.Receita;
import com.publica.desafiopublica.repository.ReceitaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita salvaReceita(@RequestBody Receita receita) {
        return receitaRepository.save(receita);
    }

    public Receita listaReceitaPorId(long id) {
        return receitaRepository.findById(id);
    }

    public List<Receita> listaReceitaPorData() {
        return receitaRepository.findAll(Sort.by(Sort.Direction.ASC, "dataRecebimento"));
    }

    public List<Receita> listaReceitaPorTipo() {
        return receitaRepository.findAll(Sort.by(Sort.Direction.ASC, "tipoReceita"));
    }

    public Double exibeReceitaTotal() {
        return receitaRepository.valorTotalReceitas();
    }

    public Receita atualizaReceita(Long id, Receita receita) {
        var receitaEncontrada = listaReceitaPorId(id);
        BeanUtils.copyProperties(receita, receitaEncontrada, "id");
        return receitaRepository.save(receitaEncontrada);
    }

    public void deletaReceita(Long id) {
        receitaRepository.deleteById(id);
    }

}
