package com.publica.desafiopublica.models;

import com.publica.desafiopublica.enums.TipoConta;

import javax.persistence.*;

@Entity
@Table(name = "TB_CONTAS")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double saldo;

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;
    private String instituicaoFinanceira;
    private String numeroConta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

}
