package com.publica.desafiopublica.models;

public class DadosTransferencia {

    private String numeroContaOrigem;
    private String numeroContaDestino;
    private double valorTransferencia;

    public String getNumeroContaOrigem() {
        return numeroContaOrigem;
    }

    public void setNumeroContaOrigem(String numeroContaOrigem) {
        this.numeroContaOrigem = numeroContaOrigem;
    }

    public String getNumeroContaDestino() {
        return numeroContaDestino;
    }

    public void setNumeroContaDestino(String numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }

    public double getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

}
