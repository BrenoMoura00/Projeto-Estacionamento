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
        if (ticket == null) {
            return "Ticket não pode ser nulo";
        }

        if (ticket.getVeiculo() == null) {
            return "Veículo é obrigatório";
        }

        if (ticket.getTempoPermanencia() == null || ticket.getTempoPermanencia() <= 0) {
            return "Tempo de permanência é obrigatório e deve ser maior que zero";
        }

        if (ticket.getFuncionario() == null) {
            return "Funcionário é obrigatório";
        }

        try {
            ticketRepository.create(ticket);
            return "Ticket cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar ticket: " + e.getMessage();
        }
    }

    @Override
    public TicketModel buscarTicketPorId(Long id) {
        if (id == null) {
            return null;
        }
        return ticketRepository.read(id.intValue());
    }

    @Override
    public List<TicketModel> buscarTicketsPorCliente(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return null;
        }
        return ticketRepository.findByClienteCpf(cpf);
    }

    @Override
    public String atualizarTicket(TicketModel ticket) {
        if (ticket == null) {
            return "Ticket não pode ser nulo";
        }

        if (ticket.getId() == null) {
            return "ID do ticket é obrigatório";
        }

        if (ticket.getVeiculo() == null) {
            return "Veículo é obrigatório";
        }

        if (ticket.getTempoPermanencia() == null || ticket.getTempoPermanencia() <= 0) {
            return "Tempo de permanência é obrigatório e deve ser maior que zero";
        }

        if (ticket.getFuncionario() == null) {
            return "Funcionário é obrigatório";
        }

        try {
            ticketRepository.update(ticket);
            return "Ticket atualizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar ticket: " + e.getMessage();
        }
    }

    @Override
    public String removerTicket(Long id) {
        if (id == null) {
            return "ID do ticket não pode ser nulo";
        }

        try {
            ticketRepository.delete(id.intValue());
            return "Ticket removido com sucesso!";
        } catch (Exception e) {
            return "Erro ao remover ticket: " + e.getMessage();
        }
    }

    @Override
    public List<TicketModel> listarTodosTickets() {
        return ticketRepository.listarTodos();
    }
} 