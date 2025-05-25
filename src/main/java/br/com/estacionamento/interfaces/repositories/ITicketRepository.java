package br.com.estacionamento.interfaces.repositories;

import br.com.estacionamento.entities.model.TicketModel;
import java.util.List;

public interface ITicketRepository extends IDAO<TicketModel> {
    List<TicketModel> findByClienteCpf(String cpf);
    List<TicketModel> listarTodos();
}
