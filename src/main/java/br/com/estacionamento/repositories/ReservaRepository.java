package br.com.estacionamento.repositories;

import br.com.estacionamento.entities.Reserva;
import br.com.estacionamento.interfaces.repositories.IReservaRepository;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepository implements IReservaRepository {
    private List<Reserva> reservas = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void salvar(Reserva reserva) {
        reserva.setId(proximoId++);
        reservas.add(reserva);
    }

    @Override
    public void remover(int id) {
        reservas.removeIf(r -> r.getId() == id);
    }

    @Override
    public void atualizar(Reserva reserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId() == reserva.getId()) {
                reservas.set(i, reserva);
                break;
            }
        }
    }

    @Override
    public List<Reserva> listarTodos() {
        return new ArrayList<>(reservas);
    }

    @Override
    public Reserva buscarPorId(int id) {
        return reservas.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reserva> listarReservasAtivas() {
        return reservas.stream()
                .filter(r -> r.getDataHoraSaida() == null)
                .toList();
    }
}
