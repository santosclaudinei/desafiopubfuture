package com.publica.desafiopublica.resources;

import com.publica.desafiopublica.models.Conta;
import com.publica.desafiopublica.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ContaResource {

    @Autowired
    private ContaRepository contaRepository;

    @PostMapping("/conta")
    public Conta salvaConta(@RequestBody Conta conta) {
        return contaRepository.save(conta);
    }

    @GetMapping("/contas")
    public List<Conta> listaContas() {
        return (List<Conta>) contaRepository.findAll();
    }

    @GetMapping("/contas/{id}")
    public Conta listaContaPorId(@PathVariable(value="id") long id) {
        return contaRepository.findById(id);
    }

    @PutMapping("/conta")
    public Conta AtualizaConta(@RequestBody Conta conta) {
        return contaRepository.save(conta);
    }

    @DeleteMapping("/conta")
    public void deletaConta(@RequestBody Conta conta) {
        contaRepository.delete(conta);
    }


}
