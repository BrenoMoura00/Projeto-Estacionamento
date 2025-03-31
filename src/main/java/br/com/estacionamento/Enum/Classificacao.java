package br.com.estacionamento.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum Classificacao {
    Cadeirante("Cadeirante"),
    Idoso("Idoso"),
    Comum("Comum");

    private final String classificacao;

}
