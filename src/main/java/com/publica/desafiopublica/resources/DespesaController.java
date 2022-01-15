package com.publica.desafiopublica.resources;

import com.publica.desafiopublica.models.Despesa;
import com.publica.desafiopublica.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Despesa salvaDespesa(@RequestBody Despesa despesa) {
            return despesaService.salvaDespesa(despesa);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesa listaDespesaPorId(@PathVariable("id") Long id) {
        return despesaService.listaDespesaPorId(id);
    }

    @GetMapping("/data")
    @ResponseStatus(HttpStatus.OK)
    public List<Despesa> listaDespesaPorData() {
        return despesaService.listaDespesaPorData();
    }

    @GetMapping("/tipo")
    @ResponseStatus(HttpStatus.OK)
    public List<Despesa> listaDespesaPorTipo() {
        return despesaService.listaDespesaPorTipo();
    }

    @GetMapping("/total")
    @ResponseStatus(HttpStatus.OK)
    public String listaDespesaTotal() {
        return ("Total das despesa R$ " + despesaService.exibeDespesaTotal());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesa atualizaDespesa(@PathVariable("id") Long id, @RequestBody Despesa despesa) {
        return despesaService.atualizaDespesa(id, despesa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaDespesa(@PathVariable("id") Long id) {
        despesaService.deletaDespesa(id);
    }

}
