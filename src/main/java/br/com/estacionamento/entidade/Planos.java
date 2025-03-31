package br.com.estacionamento.entidade;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Planos {
    private String nome;
    private double valor;
    private int qtnHoras;
    private int qtnVeiculos;
    private int qtnDias;
}
