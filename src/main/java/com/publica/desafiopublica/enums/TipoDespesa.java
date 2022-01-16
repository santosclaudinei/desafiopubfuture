package com.publica.desafiopublica.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TipoDespesa {

    @JsonProperty("Alimentacao")
    ALIMENTACAO,

    @JsonProperty("Educacao")
    EDUCACAO,

    @JsonProperty("Lazer")
    LAZER,

    @JsonProperty("Moradia")
    MORADIA,

    @JsonProperty("Roupa")
    ROUPA,

    @JsonProperty("Saude")
    SAUDE,

    @JsonProperty("Trasnporte")
    TRANSPORTE,

    @JsonProperty("Outros")
    OUTROS;

}
