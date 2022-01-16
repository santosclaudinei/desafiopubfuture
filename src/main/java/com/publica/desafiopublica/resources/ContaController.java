package com.publica.desafiopublica.resources;

import com.publica.desafiopublica.exceptions.EntidadeNaoEncontradaException;
import com.publica.desafiopublica.models.Conta;
import com.publica.desafiopublica.models.DadosTransferencia;
import com.publica.desafiopublica.services.ContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/conta")
@Api(value = "API REST Gestão Financeira")
@CrossOrigin(origins = "*")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria uma conta")
    public Conta salvaConta(@RequestBody Conta conta) {
        return contaService.salvaConta(conta);
    }

    @GetMapping
    @ApiOperation(value = "Lista todas as contas")
    public ResponseEntity <List<Conta>> listaContas() {
        var contas = (List<Conta>) contaService.listaContas();
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Lista uma conta através de um ID informado")
    public ResponseEntity<?> listaContaPorId(@PathVariable(value="id") long id) {
        try {
            var contaEncontrada = contaService.listaContaPorId(id);
            return ResponseEntity.ok().body(contaEncontrada);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/total")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Mostra o saldo total das contas")
    public String ListaSaldoTotal() {
        return ("Saldo total R$ " + contaService.exibeSaldoTotal());
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma conta através de um ID informado")
    public ResponseEntity<?> atualizaconta(@PathVariable("id") Long id, @RequestBody Conta conta) {
        try {
            var contaAtualizada = contaService.atualizaConta(id, conta);
            return ResponseEntity.status(HttpStatus.OK).body(contaAtualizada);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PostMapping("/transferencia")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Realiza transferência entre duas contas")
    public String transfereValores(@RequestBody DadosTransferencia dadosTransferencia) {
        return contaService.transferir(dadosTransferencia);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma contra através de um ID informado")
    public ResponseEntity<?> deletaConta(@PathVariable("id") Long id) {

        try {
            contaService.deletaConta(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
