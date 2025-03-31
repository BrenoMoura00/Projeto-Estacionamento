package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.Reserva;

import java.util.List;

public interface IResercaService {
    void realizarReserva(Reserva reserva);
    Reserva buscarReservaPorId(int id);
    void cancelarReserva(int id);
    void finalizarReserva(int id);
    List<Reserva> listarTodasReservas();
    List<Reserva> listarReservasAtivas();
}
