package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.ReservaModel;
import java.time.LocalDateTime;
import java.util.List;

public interface IReservaRepository extends IDAO<ReservaModel> {
    List<ReservaModel> findByClienteId(int clienteId);
    List<ReservaModel> findByVagaId(int vagaId);
    List<ReservaModel> findByDataInicioBetween(LocalDateTime inicio, LocalDateTime fim);
    List<ReservaModel> findByDataFimBetween(LocalDateTime inicio, LocalDateTime fim);
    List<ReservaModel> findByStatus(String status);
    List<ReservaModel> findByEstacionamentoId(int estacionamentoId);
    List<ReservaModel> findByVeiculoId(int veiculoId);
}
