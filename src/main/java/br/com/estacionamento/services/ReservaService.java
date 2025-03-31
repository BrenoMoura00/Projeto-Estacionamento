package br.com.estacionamento.services;

import br.com.estacionamento.entities.Reserva;
import br.com.estacionamento.interfaces.services.IResercaService;
import br.com.estacionamento.interfaces.repositories.IReservaRepository;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ReservaService implements IResercaService {
    private final IReservaRepository reservaRepository;
    private static final double VALOR_HORA = 10.0;
    private static final double VALOR_DIARIA = 50.0;

    public ReservaService(IReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public void realizarReserva(Reserva reserva) {
        if (!reserva.getVaga().isDisponivel()) {
            throw new IllegalStateException("Vaga não está disponível");
        }
        reserva.getVaga().setDisponivel(false);
        reservaRepository.salvar(reserva);
    }

    @Override
    public Reserva buscarReservaPorId(int id) {
        return reservaRepository.buscarPorId(id);
    }

    @Override
    public void cancelarReserva(int id) {
        Reserva reserva = reservaRepository.buscarPorId(id);
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva não encontrada");
        }
        reserva.getVaga().setDisponivel(true);
        reservaRepository.remover(id);
    }

    @Override
    public void finalizarReserva(int id) {
        Reserva reserva = reservaRepository.buscarPorId(id);
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva não encontrada");
        }

        reserva.setDataHoraSaida(LocalDateTime.now());
        long horas = ChronoUnit.HOURS.between(reserva.getDataHoraEntrada(), reserva.getDataHoraSaida());

        if (horas <= 12) {
            reserva.setValor(horas * VALOR_HORA);
        } else {
            long dias = ChronoUnit.DAYS.between(reserva.getDataHoraEntrada(), reserva.getDataHoraSaida());
            reserva.setValor((dias + 1) * VALOR_DIARIA);
        }

        reserva.getVaga().setDisponivel(true);
        reservaRepository.atualizar(reserva);
    }

    @Override
    public List<Reserva> listarTodasReservas() {
        return reservaRepository.listarTodos();
    }

    @Override
    public List<Reserva> listarReservasAtivas() {
        return reservaRepository.listarReservasAtivas();
    }
}
