package br.com.estacionamento.services;

import br.com.estacionamento.entities.model.TicketModel;
import br.com.estacionamento.interfaces.services.ITicketService;
import br.com.estacionamento.repositories.TicketRepository;
import java.util.List;

public class TicketService implements ITicketService {
    
    private TicketRepository ticketRepository;

    public TicketService() {
        this.ticketRepository = new TicketRepository();
    }

    @Override
    public String cadastrarTicket(TicketModel ticket) {
        return null;
    }

    @Override
    public TicketModel buscarTicketPorId(Long id) {
        return null;
    }

    @Override
    public List<TicketModel> buscarTicketsPorCliente(String cpf) {
        return null;
    }

    @Override
    public String atualizarTicket(TicketModel ticket) {
        return null;
    }

    @Override
    public String removerTicket(Long id) {
        return null;
    }

    @Override
    public List<TicketModel> listarTodosTickets() {
        return null;
    }
} 