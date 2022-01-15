package com.publica.desafiopublica.resources;

import com.publica.desafiopublica.models.Receita;
import com.publica.desafiopublica.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Receita salvaReceita(@RequestBody Receita receita) {
        return receitaService.salvaReceita(receita);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receita listaReceitaPorId(@PathVariable("id") Long id) {
        return receitaService.listaReceitaPorId(id);
    }

    @GetMapping("/data")
    @ResponseStatus(HttpStatus.OK)
    public List<Receita> listaReceitaPorData() {
        return receitaService.listaReceitaPorData();
    }

    @GetMapping("/tipo")
    @ResponseStatus(HttpStatus.OK)
    public List<Receita> listaReceitaPorTipo() {
        return receitaService.listaReceitaPorTipo();
    }

    @GetMapping("/total")
    @ResponseStatus(HttpStatus.OK)
    public String listaReceitaTotal() {
        return ("Receita total R$ " + receitaService.exibeReceitaTotal());
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaReceita(@PathVariable("id") Long id) {
        receitaService.deletaReceita(id);
    }

}
