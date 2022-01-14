package com.publica.desafiopublica.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_DESPESAS")
public class Despesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public double valor;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamento;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamentoEsperado;
    private String tipoDespesa;
    @ManyToOne
    public Conta conta;

    public Despesa() {
    }

    public Despesa(double valor, Date dataPagamento, Date dataPagamentoEsperado,
                   String tipoDespesa, Conta conta) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataPagamentoEsperado() {
        return dataPagamentoEsperado;
    }

    public void setDataPagamentoEsperado(Date dataPagamentoEsperado) {
        this.dataPagamentoEsperado = dataPagamentoEsperado;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
