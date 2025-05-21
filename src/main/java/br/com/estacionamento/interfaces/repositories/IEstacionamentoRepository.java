package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.EstacionamentoModel;
import java.util.List;

public interface IEstacionamentoRepository extends IDAO<EstacionamentoModel> {
    List<EstacionamentoModel> findByNome(String nome);
    List<EstacionamentoModel> findByCidade(String cidade);
    List<EstacionamentoModel> findByCapacidadeGreaterThan(int capacidade);
}