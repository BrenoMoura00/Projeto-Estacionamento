package br.com.estacionamento.services;

import java.time.LocalDateTime;
import java.util.List;

import br.com.estacionamento.entities.model.ReservaModel;
import br.com.estacionamento.interfaces.services.IReservaService;
import br.com.estacionamento.repositories.ReservaRepository;

public class ReservaService implements IReservaService {
    private ReservaRepository reservaRepository;

    public ReservaService() {
        this.reservaRepository = new ReservaRepository();
    }

    @Override
    public String cadastrarReserva(ReservaModel reserva) {
        if (reserva == null) {
            return "Reserva não pode ser nula";
        }

        if (reserva.getVaga() == null) {
            return "Vaga é obrigatória";
        }

        if (reserva.getCliente() == null) {
            return "Cliente é obrigatório";
        }

        if (reserva.getDataHoraEntrada() == null) {
            return "Data e hora de entrada são obrigatórias";
        }

        if (reserva.getDataHoraEntrada().isBefore(LocalDateTime.now())) {
            return "Data e hora de entrada não podem ser anteriores ao momento atual";
        }

        try {
            reservaRepository.create(reserva);
            return "Reserva cadastrada com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar reserva: " + e.getMessage();
        }
    }

    @Override
    public ReservaModel buscarReservaPorId(Long id) {
        if (id == null) {
            return null;
        }
        return reservaRepository.read(id.intValue());
    }

    @Override
    public List<ReservaModel> buscarReservasPorCliente(int clienteId) {
        return reservaRepository.findByClienteId(clienteId);
    }

    @Override
    public List<ReservaModel> buscarReservasPorVaga(int vagaId) {
        return reservaRepository.findByVagaId(vagaId);
    }

    @Override
    public List<ReservaModel> buscarReservasPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        if (inicio == null || fim == null) {
            return null;
        }
        if (inicio.isAfter(fim)) {
            return null;
        }
        return reservaRepository.findByDataInicioBetween(inicio, fim);
    }

    @Override
    public List<ReservaModel> buscarReservasPorStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            return null;
        }
        return reservaRepository.findByStatus(status);
    }

    @Override
    public List<ReservaModel> buscarReservasPorEstacionamento(int estacionamentoId) {
        return reservaRepository.findByEstacionamentoId(estacionamentoId);
    }

    @Override
    public List<ReservaModel> buscarReservasPorVeiculo(int veiculoId) {
        return reservaRepository.findByVeiculoId(veiculoId);
    }

    @Override
    public String atualizarReserva(ReservaModel reserva) {
        if (reserva == null) {
            return "Reserva não pode ser nula";
        }

        if (reserva.getId() == null) {
            return "ID da reserva é obrigatório";
        }

        if (reserva.getVaga() == null) {
            return "Vaga é obrigatória";
        }

        if (reserva.getCliente() == null) {
            return "Cliente é obrigatório";
        }

        if (reserva.getDataHoraEntrada() == null) {
            return "Data e hora de entrada são obrigatórias";
        }

        try {
            reservaRepository.update(reserva);
            return "Reserva atualizada com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar reserva: " + e.getMessage();
        }
    }

    @Override
    public String removerReserva(Long id) {
        if (id == null) {
            return "ID da reserva não pode ser nulo";
        }

        try {
            reservaRepository.delete(id.intValue());
            return "Reserva removida com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover reserva: " + e.getMessage();
        }
    }

    @Override
    public List<ReservaModel> listarTodasReservas() {
        return reservaRepository.listarTodos();
    }
}
