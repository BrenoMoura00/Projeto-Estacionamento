package br.com.estacionamento.interfaces.services;

import br.com.estacionamento.entities.model.TicketModel;
import java.util.List;

public interface ITicketService {
    String cadastrarTicket(TicketModel ticket);
    TicketModel buscarTicketPorId(Long id);
    List<TicketModel> buscarTicketsPorCliente(String cpf);
    String atualizarTicket(TicketModel ticket);
    String removerTicket(Long id);
    List<TicketModel> listarTodosTickets();
} 