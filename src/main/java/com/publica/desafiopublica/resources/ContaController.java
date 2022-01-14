package com.publica.desafiopublica.resources;

import com.publica.desafiopublica.models.Conta;
import com.publica.desafiopublica.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta salvaConta(@RequestBody Conta conta) {
        return contaService.salvaConta(conta);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Conta> listaContas() {
        return (List<Conta>) contaService.listaContas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Conta listaContaPorId(@PathVariable(value="id") long id) {
        return contaService.listaContaPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Conta AtualizaConta(@PathVariable("id") Long id, @RequestBody Conta conta) {
        return contaService.AtualizaConta(id, conta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaConta(@PathVariable("id") Long id) {
        contaService.deletaConta(id);
    }

}
