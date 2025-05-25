package br.com.estacionamento.services;

import java.time.LocalDateTime;
import java.util.List;

import br.com.estacionamento.entities.model.ReservaModel;
import br.com.estacionamento.interfaces.repositories.IReservaRepository;
import br.com.estacionamento.repositories.ReservaRepository;

public class ReservaService implements IReservaRepository{
    private ReservaRepository reservaRepository;

    @Override
    public void create(ReservaModel objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ReservaModel read(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public void update(ReservaModel objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<ReservaModel> findByClienteId(int clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByClienteId'");
    }

    @Override
    public List<ReservaModel> findByVagaId(int vagaId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByVagaId'");
    }

    @Override
    public List<ReservaModel> findByDataInicioBetween(LocalDateTime inicio, LocalDateTime fim) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDataInicioBetween'");
    }

    @Override
    public List<ReservaModel> findByDataFimBetween(LocalDateTime inicio, LocalDateTime fim) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDataFimBetween'");
    }

    @Override
    public List<ReservaModel> findByStatus(String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByStatus'");
    }

    @Override
    public List<ReservaModel> findByEstacionamentoId(int estacionamentoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEstacionamentoId'");
    }

    @Override
    public List<ReservaModel> findByVeiculoId(int veiculoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByVeiculoId'");
    }
    // Realizar e validar a reserva entre 
}
