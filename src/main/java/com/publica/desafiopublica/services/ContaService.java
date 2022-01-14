package com.publica.desafiopublica.services;

import com.publica.desafiopublica.models.Conta;
import com.publica.desafiopublica.repository.ContaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta salvaConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public List<Conta> listaContas() {
        return (List<Conta>) contaRepository.findAll();
    }

    public Conta listaContaPorId(long id) {
        return contaRepository.findById(id);
    }

    public Conta AtualizaConta(Long id, Conta conta) {
        var contaEncontrada = listaContaPorId(id);
        BeanUtils.copyProperties(conta, contaEncontrada, "id");
        return contaRepository.save(contaEncontrada);
    }

    public void deletaConta(Long id) {
        contaRepository.deleteById(id);
    }

}
