package com.publica.desafiopublica.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TipoConta {

    @JsonProperty("Corrente")
    CONTA_CORRENTE,

    @JsonProperty("Poupanca")
    CONTA_POUPANCA

}
