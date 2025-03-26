package br.com.estacionamento.entidade;

import br.com.estacionamento.Enum.UF;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String cep;
    private int numero;
    private UF uf;


}
