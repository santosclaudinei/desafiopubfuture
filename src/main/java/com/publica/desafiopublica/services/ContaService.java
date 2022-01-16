package com.publica.desafiopublica.services;

import com.publica.desafiopublica.exceptions.EntidadeNaoEncontradaException;
import com.publica.desafiopublica.models.Conta;
import com.publica.desafiopublica.models.DadosTransferencia;
import com.publica.desafiopublica.repository.ContaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

        var contaEncontrada= contaRepository.findById(id);
        if(contaEncontrada == null) {
            throw  new EntidadeNaoEncontradaException(String.format("Conta de código %d não encontrada.", id));
        }
        return contaEncontrada;
    }

    public Double exibeSaldoTotal() {
        return contaRepository.valorTotalContas();
    }

    public Conta atualizaConta(Long id, Conta conta) {
        var contaEncontrada = listaContaPorId(id);
        BeanUtils.copyProperties(conta, contaEncontrada, "id");
        return contaRepository.save(contaEncontrada);
    }

    public void deletaConta(Long id) {

        try {
            contaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Conta de código %d não encontrada.", id));
        }

    }

    public String transferir(DadosTransferencia dadosTransferencia) {
        var contaOrigem = contaRepository.findByNumeroConta(dadosTransferencia.getNumeroContaOrigem());
        var contaDestino = contaRepository.findByNumeroConta(dadosTransferencia.getNumeroContaDestino());
        if(contaOrigem.getSaldo() >= dadosTransferencia.getValorTransferencia()) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - dadosTransferencia.getValorTransferencia());
            atualizaConta(contaOrigem.getId(), contaOrigem);
            contaDestino.setSaldo(contaDestino.getSaldo() + dadosTransferencia.getValorTransferencia());
            atualizaConta(contaDestino.getId(), contaDestino);
            return "Transação realizada com sucesso.";
        } else {
            return "Conta de origem não possuí saldo suficiente.";
        }

    }


}
