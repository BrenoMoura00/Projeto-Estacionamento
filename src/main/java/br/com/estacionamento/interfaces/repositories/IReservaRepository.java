package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.Reserva;

import java.util.List;

public interface IReservaRepository {
    void salvar(Reserva reserva);
    void remover(int id);
    void atualizar(Reserva reserva);
    List<Reserva> listarTodos();
    Reserva buscarPorId(int id);
    List<Reserva> listarReservasAtivas();
}
