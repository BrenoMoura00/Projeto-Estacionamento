package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.model.ReservaModel;
import br.com.estacionamento.interfaces.repositories.IReservaRepository;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class ReservaRepository extends BaseDAO<ReservaModel> implements IReservaRepository {

    public ReservaRepository() {
        super(ReservaModel.class);
    }

    @Override
    public List<ReservaModel> findByClienteId(int clienteId) {
        return executeQuery("SELECT r FROM ReservaModel r WHERE r.cliente.id = :clienteId", clienteId);
    }

    @Override
    public List<ReservaModel> findByVagaId(int vagaId) {
        return executeQuery("SELECT r FROM ReservaModel r WHERE r.vaga.id = :vagaId", vagaId);
    }

    @Override
    public List<ReservaModel> findByDataInicioBetween(LocalDateTime inicio, LocalDateTime fim) {
        TypedQuery<ReservaModel> query = em.createQuery(
                "SELECT r FROM ReservaModel r WHERE r.dataHoraEntrada BETWEEN :inicio AND :fim",
                ReservaModel.class
        );
        query.setParameter("inicio", inicio);
        query.setParameter("fim", fim);
        return query.getResultList();
    }

    @Override
    public List<ReservaModel> findByDataFimBetween(LocalDateTime inicio, LocalDateTime fim) {
        TypedQuery<ReservaModel> query = em.createQuery(
                "SELECT r FROM ReservaModel r WHERE r.dataHoraSaida BETWEEN :inicio AND :fim",
                ReservaModel.class
        );
        query.setParameter("inicio", inicio);
        query.setParameter("fim", fim);
        return query.getResultList();
    }

    @Override
    public List<ReservaModel> findByStatus(String status) {
        return executeQuery("SELECT r FROM ReservaModel r WHERE r.status = :status", status);
    }

    @Override
    public List<ReservaModel> findByEstacionamentoId(int estacionamentoId) {
        return executeQuery(
                "SELECT r FROM ReservaModel r WHERE r.estacionamento.id = :estacionamentoId",
                estacionamentoId
        );
    }

    @Override
    public List<ReservaModel> findByVeiculoId(int veiculoId) {
        return executeQuery("SELECT r FROM ReservaModel r WHERE r.veiculo.id = :veiculoId", veiculoId);
    }
}