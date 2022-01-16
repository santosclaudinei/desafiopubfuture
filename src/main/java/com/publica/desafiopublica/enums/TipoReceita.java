package com.publica.desafiopublica.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TipoReceita {

    @JsonProperty("Salario")
    SALARIO,

    @JsonProperty("Presente")
    PRESENTE,

    @JsonProperty("Premio")
    PREMIO,

    @JsonProperty("Outros")
    OUTROS;

}
