package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.ReservaModel;
import java.time.LocalDateTime;
import java.util.List;

public interface IReservaService {
    String cadastrarReserva(ReservaModel reserva);
    ReservaModel buscarReservaPorId(Long id);
    List<ReservaModel> buscarReservasPorCliente(int clienteId);
    List<ReservaModel> buscarReservasPorVaga(int vagaId);
    List<ReservaModel> buscarReservasPorPeriodo(LocalDateTime inicio, LocalDateTime fim);
    List<ReservaModel> buscarReservasPorStatus(String status);
    List<ReservaModel> buscarReservasPorEstacionamento(int estacionamentoId);
    List<ReservaModel> buscarReservasPorVeiculo(int veiculoId);
    String atualizarReserva(ReservaModel reserva);
    String removerReserva(Long id);
    List<ReservaModel> listarTodasReservas();
} 