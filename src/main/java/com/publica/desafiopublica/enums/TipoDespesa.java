package com.publica.desafiopublica.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public enum TipoDespesa {

    @JsonProperty("Alimentacao")
    ALIMENTACAO("Alimentação"),

    @JsonProperty("Educacao")
    EDUCACAO("Educação"),

    @JsonProperty("Lazer")
    LAZER("Lazer"),

    @JsonProperty("Moradia")
    MORADIA("Moradia"),

    @JsonProperty("Roupa")
    ROUPA("Roupa"),

    @JsonProperty("Saude")
    SAUDE("Saúde"),

    @JsonProperty("Trasnporte")
    TRANSPORTE("Trasnporte"),

    @JsonProperty("Outros")
    OUTROS("Outros");

    @Getter
    private final String value;

    TipoDespesa(String value) {
        this.value = value;
    }

}
