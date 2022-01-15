package com.publica.desafiopublica.services;

import com.publica.desafiopublica.exceptions.EntidadeNaoEncontradaException;
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

    public Double exibeSaldoTotal() {
        return contaRepository.valorTotalContas();
    }

    public Conta atualizaConta(Long id, Conta conta) {
        var contaEncontrada = listaContaPorId(id);
        BeanUtils.copyProperties(conta, contaEncontrada, "id");
        return contaRepository.save(contaEncontrada);
    }

    public void deletaConta(Long id) {
        contaRepository.deleteById(id);
    }


    public Conta sacar(double valor, Conta contaOrigem) {
        try{
            if (contaOrigem.getSaldo() >= valor) {
                var novoSaldoOrigem = contaOrigem.getSaldo() - valor;
                contaOrigem.setSaldo(novoSaldoOrigem);
            }
        } catch (EntidadeNaoEncontradaException e){
            // COMPLETAR CÓDIGO
        }
        return contaOrigem;
    }

    public void depositar(double valor, Conta contaDestino) {
        var novoSaldoDestino = contaDestino.getSaldo() + valor;
        contaDestino.setSaldo(novoSaldoDestino);
    }

    public Conta transferir(double valor, Conta contaDestino, Conta contaOrigem) {
        sacar(valor, contaOrigem);
        depositar(valor, contaDestino);
        return contaDestino;
    }

}
