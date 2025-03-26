package br.com.estacionamento.entidade;

import br.com.estacionamento.Enum.Classificacao;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Vagas {
    private int id;
    private int andar;
    private String setor;
    private boolean ocupada;
    private Classificacao classificacao;
}
