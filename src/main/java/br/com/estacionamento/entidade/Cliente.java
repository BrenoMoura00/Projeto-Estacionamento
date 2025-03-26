package br.com.estacionamento.entidade;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private int idade;
    private Endereco endereco;

}
