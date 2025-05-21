package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.VagaModel;
import java.util.List;

public interface IVagaRepository extends IDAO<VagaModel> {
    List<VagaModel> findByNumero(String numero);
    List<VagaModel> findByTipo(String tipo);
    List<VagaModel> findByDisponivel(boolean disponivel);
    List<VagaModel> findByEstacionamentoId(int estacionamentoId);
    VagaModel findByNumeroAndEstacionamentoId(String numero, int estacionamentoId);
}