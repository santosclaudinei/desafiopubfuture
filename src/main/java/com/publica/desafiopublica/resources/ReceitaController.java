package com.publica.desafiopublica.resources;

import com.publica.desafiopublica.exceptions.EntidadeNaoEncontradaException;
import com.publica.desafiopublica.models.Receita;
import com.publica.desafiopublica.services.ReceitaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria uma Receita")
    public Receita salvaReceita(@RequestBody Receita receita) {
        return receitaService.salvaReceita(receita);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Lista uma receita através de um ID informado")
    public ResponseEntity<?> listaReceitaPorId(@PathVariable("id") Long id) {
        try {
            var receitaEncontrada = receitaService.listaReceitaPorId(id);
            return ResponseEntity.ok().body(receitaEncontrada);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @GetMapping("/data")
    @ApiOperation(value = "Lista todas as receitas por ordem ascedente baseado na data de pagamento")
    public ResponseEntity <List<Receita>> listaReceitaPorData() {
        var receitas = (List<Receita>) receitaService.listaReceitaPorData();
        return ResponseEntity.ok(receitas);
    }

    @GetMapping("/tipo")
    @ApiOperation(value = "Lista todas as receitas por ordem ascendente baseado no tipo de receita")
    public ResponseEntity <List<Receita>> listaReceitaPorTipo() {
        var receitas = (List<Receita>) receitaService.listaReceitaPorTipo();
        return ResponseEntity.ok(receitas);
    }

    @GetMapping("/total")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Mostra o saldo total das receitas")
    public String listaReceitaTotal() {
        return ("Receita total R$ " + receitaService.exibeReceitaTotal());
    }


    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma receita através de um ID informado")
    public ResponseEntity<?> atualizaReceita(@PathVariable("id") Long id, @RequestBody Receita receita) {

        try {
            var receitaAtualizada = receitaService.atualizaReceita(id, receita);
            return ResponseEntity.status(HttpStatus.OK).body(receitaAtualizada);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma receita através de um ID informado")
    public ResponseEntity<?> deletaReceita(@PathVariable("id") Long id) {
        try {
            receitaService.deletaReceita(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

}
