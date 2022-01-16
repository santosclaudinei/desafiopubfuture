package com.publica.desafiopublica.resources;

import com.publica.desafiopublica.exceptions.EntidadeNaoEncontradaException;
import com.publica.desafiopublica.models.Despesa;
import com.publica.desafiopublica.services.DespesaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria uma despesa")
    public Despesa salvaDespesa(@RequestBody Despesa despesa) {
            return despesaService.salvaDespesa(despesa);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Lista uma despesa através de um ID informado")
    public ResponseEntity<?> listaDespesaPorId(@PathVariable("id") Long id) {

        try {
            var despesaEncontrada = despesaService.listaDespesaPorId(id);
            return ResponseEntity.ok().body(despesaEncontrada);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @GetMapping("/data")
    @ApiOperation(value = "Lista todas as despesas por ordem ascedente baseado na data de pagamento")
    public ResponseEntity <List<Despesa>> listaDespesaPorData() {
        var despesas = (List<Despesa>) despesaService.listaDespesaPorData();
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/tipo")
    @ApiOperation(value = "Lista todas as despesas por ordem ascendente baseado no tipo de despesa")
    public ResponseEntity <List<Despesa>> listaDespesaPorTipo() {
        var despesas = (List<Despesa>) despesaService.listaDespesaPorTipo();
        return ResponseEntity.ok(despesas);
    }

    @GetMapping("/total")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Mostra o saldo total das despesas")
    public String listaDespesaTotal() {
        return ("Total das despesa R$ " + despesaService.exibeDespesaTotal());
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma despesa através de um ID informado")
    public ResponseEntity<?> atualizaDespesa(@PathVariable("id") Long id, @RequestBody Despesa despesa) {

        try {
            var despesaAtualizada = despesaService.atualizaDespesa(id, despesa);
            return ResponseEntity.status(HttpStatus.OK).body(despesaAtualizada);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma despesa através de um ID informado")
    public ResponseEntity<?> deletaDespesa(@PathVariable("id") Long id) {

        try {
            despesaService.deletaDespesa(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

}
